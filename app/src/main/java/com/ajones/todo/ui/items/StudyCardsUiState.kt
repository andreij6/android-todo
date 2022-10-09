package com.ajones.todo.ui.items

sealed interface StudyCardsUiState

object Initializing : StudyCardsUiState
object FailedState : StudyCardsUiState

data class ReadyState(
    val todoItems: List<StudyCardUi>
) : StudyCardsUiState

