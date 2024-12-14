package com.example.focusscore.presentation.focus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FocusScoreViewModel @Inject constructor(
) : ViewModel() {



    private val _state = MutableStateFlow(FocusScoreUiState())
    val state: StateFlow<FocusScoreUiState> = _state.asStateFlow()



    fun focusScoreRandomized() {

        viewModelScope.launch {
                    _state.update {
                        it.copy(focusScore = Random.nextInt(0, 101))
                    }
            }
    }

    fun startAndStop() {
        _state.update { it.copy(startAndStop = !it.startAndStop) }
    }


    fun resetScore() {
        _state.update {
            it.copy(
                focusScore = 0,
                startAndStop = false
            )
        }
    }




}