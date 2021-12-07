package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.ProductDao
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            dataSourceDb.getAllProducts()
        }
    }

    suspend fun insertProducts(products: List<Product>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllProducts()
            if (temp.isEmpty()) {
                dataSourceDb.insertProducts(products)
            }
        }
    }
}