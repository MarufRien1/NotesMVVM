package bd.maruf.notesmvvm.presentation.note_list

import bd.maruf.notesmvvm.domain.model.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)