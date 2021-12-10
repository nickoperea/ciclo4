package com.nickoperea.inventariapp.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.nickoperea.inventariapp.data.databases.dao.CommentDao
import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.utils.COMMENT_TABLE_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CommentRepository(
    val dataSource: CommentMock,
    private val dataSourceDb: CommentDao,
    private val dataSourceFirebaseStorage: FirebaseFirestore
) {

    val db: CollectionReference = dataSourceFirebaseStorage.collection(COMMENT_TABLE_NAME)

    suspend fun loadComments(): List<Comment> {
        return withContext(Dispatchers.IO) {
            val snapshot = db.get().await()
            snapshot.toObjects(Comment::class.java)
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