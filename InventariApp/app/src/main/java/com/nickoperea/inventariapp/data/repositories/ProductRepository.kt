package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.models.Product

class ProductRepository(val dataSource: ProductMock) {
    suspend fun loadData(): List<Product> {
        return dataSource.loadData()
    }
}