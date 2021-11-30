package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.models.Comment

class CommentRepository(val dataSource: CommentMock) {
    suspend fun loadData(): List<Comment> {
        return dataSource.loadData()
    }
}