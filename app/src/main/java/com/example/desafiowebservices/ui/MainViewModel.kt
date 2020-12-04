package com.example.desafiowebservices.ui

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservices.`class`.Res
import com.example.desafiowebservices.service.Repository
import com.example.desafiowebservices.service.repository
import kotlinx.coroutines.launch

class MainViewModel(repository: Repository) : ViewModel() {

    var listQhsFromApi = MutableLiveData<Res>()

    fun getHqs() {
        viewModelScope.launch {
            listQhsFromApi.value = repository.getResults(1, 70, "1", "b6d14cee3a6ce6d6169a34b10322dfeb", "fb691868ae0082f1da1d9f40513bbca7", "spider-man", "focDate", true, "2019-03-01,2020-01-04")
        }
    }
}