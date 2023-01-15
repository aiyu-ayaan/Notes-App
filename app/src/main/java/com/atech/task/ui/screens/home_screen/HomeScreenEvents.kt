package com.atech.task.ui.screens.home_screen

import com.atech.task.database.NoteModel

sealed class HomeScreenEvents {
    data class DeleteNote(val note: NoteModel) : HomeScreenEvents()
    data class ShowBottomSheet(val note: NoteModel) : HomeScreenEvents()
    object HideBottomSheet : HomeScreenEvents()
    object RestoreNote : HomeScreenEvents()
}