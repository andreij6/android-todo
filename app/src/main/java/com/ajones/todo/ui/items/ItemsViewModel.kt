package com.ajones.todo.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItemsViewModel(

) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(2000)
            _uiState.value = ReadyState(emptyList())
        }
    }

    private val _uiState: MutableLiveData<ItemsUiState> = MutableLiveData(Initializing)
    val uiState: LiveData<ItemsUiState> = _uiState

}

