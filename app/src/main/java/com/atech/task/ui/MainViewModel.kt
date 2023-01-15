package com.atech.task.ui

import androidx.lifecycle.ViewModel
import com.atech.task.database.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {
    val allNote = repository.allNotes
}