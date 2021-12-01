package com.nickoperea.inventariapp.data.models

data class Product (
    var id: Long,
    var name: String,
    var image: String,
    var description: String,
    var price: Double,
    var stock: Int
)