package com.nickoperea.inventariapp.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nickoperea.inventariapp.data.models.StoreInfo
import com.nickoperea.inventariapp.utils.STORE_TABLE_NAME

@Dao
interface StoreDao {
    @Insert
    suspend fun insertStore(store: StoreInfo)

    @Query("SELECT * FROM products LIMIT 1")
    suspend fun getStore(): StoreInfo?
}