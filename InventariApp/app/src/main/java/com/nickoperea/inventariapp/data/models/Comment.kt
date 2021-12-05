package com.nickoperea.inventariapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "comments")

data class Comment(
    @PrimaryKey var id: Long,
    var description: String?,
    var author: String?,
    var image: String?,
    var date: String?
)