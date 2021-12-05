package com.nickoperea.inventariapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stores")

data class StoreInfo (
    @PrimaryKey var id: Long,
    var name: String?,
    var image: String?,
    var address: String?,
    var description: String?,
    var latitude: Double? = null,
    var longitude: Double? = null
)