package com.atech.task.ui.screens.home_screen

import com.atech.task.database.NoteModel

data class HomeScreenState(
    val note: List<NoteModel> = emptyList(),
    val isBottomSheetVisible: Boolean = false
)