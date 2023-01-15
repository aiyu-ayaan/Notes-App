package com.atech.task.ui.screens.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atech.task.database.NoteModel
import com.atech.task.database.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {
    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    private var getNoteJob: Job? = null

    private var recentlyDeletedNote: NoteModel? = null

    init {
        getAllNotes()
    }

    fun onEventChange(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.DeleteNote -> {
                viewModelScope.launch {
                    repository.delete(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            HomeScreenEvents.HideBottomSheet -> {
                _state.value = _state.value.copy(isBottomSheetVisible = false)
            }

            HomeScreenEvents.RestoreNote -> {
                viewModelScope.launch {
                    repository.insert(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is HomeScreenEvents.ShowBottomSheet -> {
                _state.value = _state.value.copy(isBottomSheetVisible = false)
            }
        }
    }

    private fun getAllNotes() {
        getNoteJob?.cancel()
        getNoteJob = repository.allNotes.onEach { notes ->
            _state.value = _state.value.copy(note = notes)
        }.launchIn(viewModelScope)
    }
}