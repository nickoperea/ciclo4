package com.nickoperea.inventariapp.data.models

data class StoreInfo (
    var id: Long,
    var name: String,
    var image: String,
    var address: String,
    var description: String,
    var latitude: Double? = null,
    var longitude: Double? = null
)