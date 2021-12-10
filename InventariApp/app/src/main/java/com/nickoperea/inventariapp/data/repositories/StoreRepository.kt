package com.nickoperea.inventariapp.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.nickoperea.inventariapp.data.databases.dao.StoreDao
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import com.nickoperea.inventariapp.data.models.StoreInfo
import com.nickoperea.inventariapp.utils.STORE_TABLE_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class StoreRepository(
    val dataSource: StoreInfoMock,
    private val dataSourceDb: StoreDao,
    private val dataSourceFirebaseStorage: FirebaseFirestore
) {

    val db: CollectionReference = dataSourceFirebaseStorage.collection(STORE_TABLE_NAME)

    suspend fun loadInfo(): StoreInfo? {
        return withContext(Dispatchers.IO) {
            val snapshot = db.get().await()
            snapshot.toObjects(StoreInfo::class.java)[0]
        }
    }

    suspend fun insertInfo(storeInfo: StoreInfo) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getStore()
            if (temp == null) {
                dataSourceDb.insertStore(storeInfo)
            }
        }
    }
}