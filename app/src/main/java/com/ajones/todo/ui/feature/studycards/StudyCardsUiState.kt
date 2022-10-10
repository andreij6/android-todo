package com.ajones.todo.ui.feature.studycards

sealed interface StudyCardsUiState

object Initializing : StudyCardsUiState
object FailedState : StudyCardsUiState

data class ReadyState(
    val cards: List<StudyCardUi>
) : StudyCardsUiState

