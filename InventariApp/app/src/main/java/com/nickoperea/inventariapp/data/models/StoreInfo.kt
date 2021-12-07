package com.nickoperea.inventariapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nickoperea.inventariapp.utils.STORE_TABLE_NAME

@Entity(tableName = STORE_TABLE_NAME)
data class StoreInfo (
    @PrimaryKey @ColumnInfo(name = "id") var id: Long = 0L,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "image") var image: String? = "",
    @ColumnInfo(name = "address") var address: String? = "",
    @ColumnInfo(name = "description") var description: String? = "",
    @ColumnInfo(name = "latitude") var latitude: Double? = 0.0,
    @ColumnInfo(name = "longitude") var longitude: Double? = 0.0
)