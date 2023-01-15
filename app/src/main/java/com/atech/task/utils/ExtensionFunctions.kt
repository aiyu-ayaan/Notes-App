package com.atech.task.utils

import android.annotation.SuppressLint
import com.atech.task.database.NoteModel
import java.text.SimpleDateFormat
import java.util.TimeZone


const val DATE_FORMAT = "yyyy-MM-dd"


val DUMMY_LIST = listOf(
    NoteModel("Task 1", "Content for task 1"),
    NoteModel("Task 2", "Content for task 2"),
    NoteModel("Task 3", "Content for task 3"),
    NoteModel("Task 4", "Content for task 4"),
    NoteModel("Task 5", "Content for task 5"),
    NoteModel("Task 6", "Content for task 6"),
    NoteModel("Task 7", "Content for task 7"),
    NoteModel("Task 8", "Content for task 8"),
    NoteModel("Task 9", "Content for task 9"),
    NoteModel("Task 10", "Content for task 10"),
    NoteModel("Task 11", "Content for task 11"),
    NoteModel("Task 12", "Content for task 12")
)

@SuppressLint("SimpleDateFormat")
fun Long.formatTime(): String = this.run {
    val simpleDateFormat = SimpleDateFormat(DATE_FORMAT)
    simpleDateFormat.timeZone = TimeZone.getDefault()
    simpleDateFormat.format(this)
}