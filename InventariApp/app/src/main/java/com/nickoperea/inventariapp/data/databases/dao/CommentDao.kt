package com.nickoperea.inventariapp.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.utils.COMMENT_TABLE_NAME

@Dao
interface CommentDao {
    @Insert
    fun insertComments(comments: List<Comment>)

    @Query("SELECT * FROM $COMMENT_TABLE_NAME")
    fun getAllComments(): List<Comment>
}