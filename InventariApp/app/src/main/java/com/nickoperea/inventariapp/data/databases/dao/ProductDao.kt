package com.nickoperea.inventariapp.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.utils.PRODUCT_TABLE_NAME

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProducts(products: List<Product>)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>
}