package bd.maruf.notesmvvm.domain.use_case

import bd.maruf.notesmvvm.domain.repositry.NoteRepository

data class NoteUseCases(
    val getNotes: GetNotes,
    val getNoteById: GetNoteById,
    val insertNote: InsertNote,
    val deleteNote: DeleteNote,

    )


class GetNotes(private val repository: NoteRepository) {
    operator fun invoke() {
        repository.getNotes()

    }
}

class GetNoteById(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int) {
        repository.getNoteById(id)
    }
}

class InsertNote(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int) {
        repository.getNoteById(id)
    }
}

class DeleteNote(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int) {
        repository.getNoteById(id)
    }
}