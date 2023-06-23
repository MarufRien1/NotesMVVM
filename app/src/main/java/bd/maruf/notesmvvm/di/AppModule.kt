package bd.maruf.notesmvvm.di

import android.app.Application
import androidx.room.Room
import bd.maruf.notesmvvm.core.Constants
import bd.maruf.notesmvvm.data.data_source.NoteDatabase
import bd.maruf.notesmvvm.data.repositry.NoteRepositoryImpl
import bd.maruf.notesmvvm.domain.repositry.NoteRepository
import bd.maruf.notesmvvm.domain.use_case.DeleteNote
import bd.maruf.notesmvvm.domain.use_case.GetNoteById
import bd.maruf.notesmvvm.domain.use_case.GetNotes
import bd.maruf.notesmvvm.domain.use_case.InsertNote
import bd.maruf.notesmvvm.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            getNoteById = GetNoteById(repository),
            insertNote = InsertNote(repository),
            deleteNote = DeleteNote(repository),
        )
    }


}