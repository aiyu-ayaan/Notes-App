package com.atech.task.ui.screens.home_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.atech.task.database.NoteModel

@Composable
fun ShowAllNotes(
    modifier: Modifier = Modifier,
    notes: List<NoteModel>
) {
    Column(modifier.padding(top = 8.dp, bottom = 30.dp)) {
        notes.forEach {
            Notes(noteModel = it)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Notes(
    noteModel: NoteModel,
    modifier: Modifier = Modifier,
    onLongClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp),
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Text(
                text = noteModel.title,
                style = MaterialTheme.typography.headlineMedium,
            )
            Text(
                modifier = Modifier.padding(4.dp),
                text = noteModel.content,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = (1..3).random(),
            )
        }
    }
}
