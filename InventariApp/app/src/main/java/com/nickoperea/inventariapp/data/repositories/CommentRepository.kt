package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.CommentDao
import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.models.Comment

class CommentRepository(private val dataSource: CommentMock, private val dataSourceDb: CommentDao) {
    suspend fun loadComments(): List<Comment> {
//    return dataSource.loadComments()
      return dataSourceDb.getAllComments()
    }

    suspend fun insertComments(comments: List<Comment>) {
        val temp = dataSourceDb.getAllComments()
        if (temp.isEmpty()) {
            dataSourceDb.insertComments(comments)
        }
    }
}
