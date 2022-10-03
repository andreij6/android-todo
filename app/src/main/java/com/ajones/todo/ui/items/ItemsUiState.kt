package com.ajones.todo.ui.items

sealed interface ItemsUiState

object Initializing : ItemsUiState
object FailedState : ItemsUiState

data class ReadyState(
    val todoItems: List<String>
) : ItemsUiState

