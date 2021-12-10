package com.nickoperea.inventariapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nickoperea.inventariapp.utils.COMMENT_TABLE_NAME

@Entity(tableName = COMMENT_TABLE_NAME)
data class Comment(
    @PrimaryKey @ColumnInfo(name = "id") var id: Long? = 0L,
    @ColumnInfo(name = "description") var description: String? = "",
    @ColumnInfo(name = "author") var author: String? = "",
    @ColumnInfo(name = "image") var image: String? = "",
    @ColumnInfo(name = "date") var date: String? = ""
) {
    constructor(): this(0L, "", "", "", "") {}
}