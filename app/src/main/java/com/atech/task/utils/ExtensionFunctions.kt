package com.atech.task.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.TimeZone


const val DATE_FORMAT = "yyyy-MM-dd"


@SuppressLint("SimpleDateFormat")
fun Long.formatTime(): String = this.run {
    val simpleDateFormat = SimpleDateFormat(DATE_FORMAT)
    simpleDateFormat.timeZone = TimeZone.getDefault()
    simpleDateFormat.format(this)
}