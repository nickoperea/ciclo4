package com.nickoperea.inventariapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.data.repositories.CommentRepository
import kotlinx.coroutines.launch

class CommentViewModel(private val repo: CommentRepository): ViewModel() {
    private var _data: MutableLiveData<List<Comment>> = MutableLiveData()
    val data: LiveData<List<Comment>> get() = _data

    fun loadData() {
        viewModelScope.launch {
            val result = repo.loadComments()
            _data.postValue(result)
        }
    }
}