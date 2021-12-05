package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.ProductDao
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.models.Product

class ProductRepository(private val dataSource: ProductMock, private val dataSourceDb: ProductDao) {
    suspend fun loadProducts(): List<Product> {
//        return dataSource.loadData()
        return dataSourceDb.getAllProducts()
    }

    suspend fun insertProducts(products: List<Product>){
        val temp = dataSourceDb.getAllProducts()
        if(temp.isEmpty()){
            dataSourceDb.insertProducts(products)
        }
    }

}