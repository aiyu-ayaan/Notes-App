package com.atech.task.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atech.task.database.NoteModel
import com.atech.task.ui.MainViewModel
import com.atech.task.ui.theme.TaskTheme
import com.atech.task.utils.DUMMY_LIST

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
) {
    val notes = remember {
        DUMMY_LIST
    }

    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            Text(
                text = "Your Tasks",
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                style = MaterialTheme.typography.titleMedium,
            )
            ShowAllTask(notes = notes)
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = {
//            TODO user navController
            }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Task")
        }
    }
}

@Composable
fun ShowAllTask(
    modifier: Modifier = Modifier,
    notes: List<NoteModel>
) {
    Column(modifier.padding(top = 8.dp)) {
        notes.forEach {
            Task(noteModel = it)
        }
    }
}


@Composable
fun Task(noteModel: NoteModel, modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TaskTheme {
        HomeScreen()
    }
}