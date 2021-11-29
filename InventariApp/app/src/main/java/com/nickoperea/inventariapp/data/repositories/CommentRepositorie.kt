package com.nickoperea.inventariapp.data.repositories

class CommentRepositorie { private val dataSource: CommentMock}{
    suspend fun loadComments(): List<Comment>{
        return dataSource.loadComments()
    }
} 

