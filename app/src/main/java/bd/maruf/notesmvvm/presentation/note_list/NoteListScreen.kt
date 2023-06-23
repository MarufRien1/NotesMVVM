package bd.maruf.notesmvvm.presentation.note_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteListScreen(viewModel: NoteListViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    if (state.notes.isEmpty()) {
        Text(text = "No Notes to show")
    }

    state.notes.forEach {
        Text(text = it.title)
    }

}