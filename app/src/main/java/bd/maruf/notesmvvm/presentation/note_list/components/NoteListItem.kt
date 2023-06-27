package bd.maruf.notesmvvm.presentation.note_list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import bd.maruf.notesmvvm.domain.model.Note

@Composable
fun NoteListItem(note: Note,onDelete:()->Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = note.title)
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
        }
    }

}