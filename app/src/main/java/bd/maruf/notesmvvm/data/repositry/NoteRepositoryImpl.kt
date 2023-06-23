package bd.maruf.notesmvvm.data.repositry

import bd.maruf.notesmvvm.data.data_source.NoteDao
import bd.maruf.notesmvvm.domain.model.Note
import bd.maruf.notesmvvm.domain.repositry.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}