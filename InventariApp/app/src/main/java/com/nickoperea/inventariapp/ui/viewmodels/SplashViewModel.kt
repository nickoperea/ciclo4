package com.nickoperea.inventariapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.data.models.StoreInfo
import com.nickoperea.inventariapp.data.repositories.CommentRepository
import com.nickoperea.inventariapp.data.repositories.ProductRepository
import com.nickoperea.inventariapp.data.repositories.StoreRepository
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repoStore: StoreRepository,
    private val repoComment: CommentRepository,
    private val repoProduct: ProductRepository
) : ViewModel() {
    fun loadInformation(store: StoreInfo, comments: List<Comment>, products: List<Product>) {
        viewModelScope.launch {
            repoStore.insertInfo(store)
            repoComment.insertComments(comments)
            repoProduct.insertProducts(products)
        }
    }
}