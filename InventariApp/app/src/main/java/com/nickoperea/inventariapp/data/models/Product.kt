package com.nickoperea.inventariapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")

data class Product (
    @PrimaryKey var id: Long,
    var name: String?,
    var image: String?,
    var description: String?,
    var price: Double?,
    var stock: Int?
)