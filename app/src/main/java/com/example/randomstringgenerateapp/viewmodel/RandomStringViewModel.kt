package com.example.randomstringgenerateapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomstringgenerateapp.model.RandomText
import com.example.randomstringgenerateapp.repository.RandomStringRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomStringViewModel @Inject constructor(private val repository: RandomStringRepository) : ViewModel() {
    private val _randomStrings = MutableStateFlow<List<RandomText>>(emptyList())
    val randomStrings: StateFlow<List<RandomText>> = _randomStrings

    fun generateRandomString(maxLength: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchRandomString(maxLength)?.let { newString ->
                _randomStrings.value = _randomStrings.value + newString
            }
        }
    }

    fun deleteAllStrings() {
        _randomStrings.value = emptyList()
    }

    fun deleteString(index: Int) {
        _randomStrings.value = _randomStrings.value.toMutableList().apply { removeAt(index) }
    }
}