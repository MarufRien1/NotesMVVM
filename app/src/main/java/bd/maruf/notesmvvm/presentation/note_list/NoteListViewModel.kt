package bd.maruf.notesmvvm.presentation.note_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bd.maruf.notesmvvm.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(private val noteUseCases: NoteUseCases):ViewModel() {
    private val _state = mutableStateOf<NoteListState>(NoteListState())
    val state: State<NoteListState> = _state

    init {
        getNotes()
    }

    fun onEvent(event: NoteListEvent){
        when(event){
            is NoteListEvent.deleteNote -> {
                viewModelScope.launch(Dispatchers.IO) {
                    noteUseCases.deleteNote(event.note)
                }
            }
        }

    }

    private fun getNotes() {
        noteUseCases.getNotes().onEach {
            _state.value=NoteListState(notes = it)
        }.launchIn(viewModelScope)
        }


    }


