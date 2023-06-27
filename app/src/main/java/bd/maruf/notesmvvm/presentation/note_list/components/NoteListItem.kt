package bd.maruf.notesmvvm.presentation.note_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import bd.maruf.notesmvvm.domain.model.Note

@Composable
fun NoteListItem(note: Note, onDelete: () -> Unit) {
    Card() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(4.dp)
            )
            Text(text = note.timeStamp.toString())
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = note.content,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,

            )

        Spacer(modifier = Modifier.height(8.dp))

        IconButton(
            onClick = onDelete,
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
        }


    }
}

val note = Note(
    id = 2,
    title = "Note 2",
    content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ut sem arcu. Vestibulum molestie tincidunt suscipit. Nunc id nulla quam. Integer eu sollicitudin purus. Morbi aliquet mollis sapien non imperdiet. Ut suscipit pellentesque sem, a fringilla dui lacinia ac. Integer pharetra viverra diam, sit amet rhoncus urna lacinia vel. Nullam eleifend imperdiet sapien et elementum. Morbi in vulputate nunc. Duis nunc enim, facilisis bibendum risus gravida, dignissim lobortis enim. Sed at viverra ipsum. Cras magna felis, pulvinar auctor orci eu, volutpat sollicitudin risus. Sed risus ipsum, lobortis nec aliquet sit amet, posuere et ligula. Curabitur quam justo, semper a sagittis vitae, fermentum et est. Donec vestibulum justo cursus rhoncus pellentesque. Pellentesque congue dapibus massa, venenatis aliquam massa pharetra eu.\n" +
            "\n" +
            "Suspendisse vel ante varius, iaculis orci eget, iaculis dui. Quisque suscipit purus at consectetur molestie. Nam volutpat, quam eget dignissim euismod, augue sem consectetur quam, id tempor enim nisi nec urna. Nunc vitae mattis augue. Maecenas suscipit, magna id volutpat tempor, ex eros mollis urna, eget mollis nunc elit et urna. In tincidunt faucibus nibh, in vehicula lacus ornare quis. Sed a diam eros.\n" +
            "\n" +
            "Sed malesuada sit amet lectus in ultrices. Sed felis nibh, vehicula vitae leo eu, volutpat posuere leo. Aliquam ullamcorper tellus ut condimentum posuere. Nulla sodales, dolor at blandit scelerisque, neque tellus fringilla neque, eu molestie purus est sed urna. Sed massa ligula, ultricies sed tellus quis, ultrices efficitur neque. Cras vestibulum massa et ante sagittis, eu efficitur massa porta. Proin posuere lacinia ultricies. Suspendisse id ipsum a nulla lobortis mattis. Donec hendrerit libero quis accumsan tristique.\n" +
            "\n" +
            "Vestibulum eleifend bibendum malesuada. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla sagittis urna in nibh sodales, in hendrerit ex vulputate. Proin feugiat nibh sit amet lectus vulputate, eu feugiat orci interdum. Duis gravida velit ut risus rutrum condimentum. Nullam vel neque et ligula eleifend faucibus. Praesent mi turpis, sodales non nibh et, blandit aliquet arcu. Mauris efficitur eleifend sapien sit amet egestas. Integer vehicula bibendum augue, id dignissim nulla condimentum quis. Phasellus vitae fermentum diam.\n" +
            "\n" +
            "Ut laoreet molestie sapien vitae sagittis. Vestibulum sit amet elit libero. Proin vitae ante blandit, lobortis lectus ac, rutrum tellus. Donec non gravida est. Nullam sed hendrerit enim. Nunc nec fringilla massa. Phasellus id ornare velit. Fusce interdum laoreet augue non tempus.",
    timeStamp = System.currentTimeMillis()
)

@Preview(showBackground = true)
@Composable
fun NoteListItemPreview() {
    NoteListItem(note = note, {})


}