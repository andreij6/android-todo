package com.ajones.todo.ui.feature.studycards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajones.todo.domain.studycards.usecase.GetStudyCards
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudyCardsViewModel @Inject constructor(
    val getStudyCards: GetStudyCards
) : ViewModel() {

    private val _uiState: MutableLiveData<StudyCardsUiState> = MutableLiveData(Initializing)
    val uiState: LiveData<StudyCardsUiState> = _uiState

    init {
        viewModelScope.launch {
            getStudyCards().collect { domainCards ->
                val uiCards = domainCards.map { StudyCardUi.mapper(it) }
                _uiState.value = ReadyState(uiCards)
            }
        }
    }



}

