package bd.maruf.notesmvvm.presentation.note_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import bd.maruf.notesmvvm.presentation.note_list.components.NoteListItem

@Composable
fun NoteListScreen(viewModel: NoteListViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    if (state.notes.isEmpty()) {
        Text(text = "No Notes to show")
    }

    LazyColumn{
//        state.notes.forEach {
//            NoteListItem(
//                note = it,
//                onDelete = {
//                    viewModel.onEvent(NoteListEvent.deleteNote(it))
//
//                }
//            )
//
//
//        }
        items(state.notes){note->
            NoteListItem(
                note = note,
                onDelete = {
                    viewModel.onEvent(NoteListEvent.deleteNote(
                        note = note
                    ))
                }
            )
        }
    }
    }

