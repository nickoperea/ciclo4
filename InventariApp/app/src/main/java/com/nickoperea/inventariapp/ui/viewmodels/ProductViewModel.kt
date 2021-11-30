package com.nickoperea.inventariapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: ProductRepository): ViewModel() {
    private var _data: MutableLiveData<List<Product>> = MutableLiveData()
    val data: LiveData<List<Product>> get() = _data

    private var _selected: MutableLiveData<Product> = MutableLiveData()
    val selected: LiveData<Product> get() = _selected

    fun loadData() {
        viewModelScope.launch {
            val result = repo.loadData()
            _data.postValue(result)
        }
    }

    fun selectProduct(product: Product) {
        _selected.postValue(product)
    }
}