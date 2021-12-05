package com.nickoperea.inventariapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nickoperea.inventariapp.utils.PRODUCT_TABLE_NAME

@Entity(tableName = PRODUCT_TABLE_NAME)
data class Product (
    @PrimaryKey @ColumnInfo(name = "id") var id: Long,
    @ColumnInfo(name = "name") var name: String?,
    @ColumnInfo(name = "image") var image: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "price") var price: Double?,
    @ColumnInfo(name = "stock") var stock: Int?
)