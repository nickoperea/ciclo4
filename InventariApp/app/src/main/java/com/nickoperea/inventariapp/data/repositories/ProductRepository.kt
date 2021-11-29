package com.nickoperea.inventariapp.data.repositories

class ProductRepository { private val dataSource: ProductMock}{
    suspend fun loadProducts(): List<Product>{
        return dataSource.loadProducts()
    }
}

