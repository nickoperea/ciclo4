package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.ProductDao
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.models.Product

class ProductRepository(val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product> {
//        return dataSource.loadProducts()
        return dataSourceDb.getAllProducts()
    }

    suspend fun insertProducts(products: List<Product>) {
        val temp = dataSourceDb.getAllProducts()
        if (temp.isEmpty()) {
            dataSourceDb.insertProducts(products)
        }
    }
}