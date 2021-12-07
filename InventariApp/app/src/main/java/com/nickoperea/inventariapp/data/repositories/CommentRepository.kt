package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.CommentDao
import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.models.Comment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommentRepository(val dataSource: CommentMock, private val dataSourceDb: CommentDao) {
    suspend fun loadComments(): List<Comment> {
        return withContext(Dispatchers.IO) {
            dataSourceDb.getAllComments()
        }
    }

    suspend fun insertComments(comments: List<Comment>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllComments()
            if (temp.isEmpty()) {
                dataSourceDb.insertComments(comments)
            }
        }
    }
}