package com.nickoperea.inventariapp.data.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nickoperea.inventariapp.data.models.Comment

@Dao
interface CommentDao {

    @Insert
    suspend fun insertComments(comments: List<Comment>)

    @Query( "SELECT * FROM comments")
    suspend fun getAllComments(): List<Comment>

}
