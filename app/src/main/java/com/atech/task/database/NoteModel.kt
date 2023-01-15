package com.atech.task.database

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.atech.task.utils.formatTime
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Keep
@Entity(tableName = "notes_table")
@Parcelize
data class NoteModel(
    val title: String,
    val content: String,
    val created: Long = System.currentTimeMillis(),
    val updated: Long? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
) : Parcelable {
    @get:Ignore
    @IgnoredOnParcel
    val formattedCreatedAT
        get() = created.formatTime()

    @get:Ignore
    @IgnoredOnParcel
    val formattedUpdatedAT
        get() = updated?.formatTime()

}