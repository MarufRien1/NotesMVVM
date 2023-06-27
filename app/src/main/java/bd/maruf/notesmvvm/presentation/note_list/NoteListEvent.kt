package bd.maruf.notesmvvm.presentation.note_list

import bd.maruf.notesmvvm.domain.model.Note

sealed class NoteListEvent {
    data class deleteNote(val note: Note) : NoteListEvent()
}
