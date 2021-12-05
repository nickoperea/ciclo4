package com.nickoperea.inventariapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickoperea.inventariapp.data.models.StoreInfo
import com.nickoperea.inventariapp.data.repositories.StoreRepository
import kotlinx.coroutines.launch

class StoreViewModel(private val repo: StoreRepository): ViewModel() {
    private var _data: MutableLiveData<StoreInfo> = MutableLiveData()
    val data: LiveData<StoreInfo> get() = _data

    fun loadData() {
        viewModelScope.launch {
            val result = repo.loadInfo()
            _data.postValue(result)
        }
    }
}