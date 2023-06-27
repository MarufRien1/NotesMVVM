package bd.maruf.notesmvvm.domain.use_case

import bd.maruf.notesmvvm.domain.model.Note
import bd.maruf.notesmvvm.domain.repositry.NoteRepository
import kotlinx.coroutines.flow.Flow

data class NoteUseCases(
    val getNotes: GetNotes,
    val getNoteById: GetNoteById,
    val insertNote: InsertNote,
    val deleteNote: DeleteNote,

    )


class GetNotes(private val repository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> {
       return repository.getNotes()

    }
}

class GetNoteById(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int) {
        repository.getNoteById(id)
    }
}

class InsertNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note:Note) {
        repository.insertNote(note)
    }
}

class DeleteNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note:Note) {
        repository.deleteNote(note)
    }
}