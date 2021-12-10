package com.nickoperea.inventariapp.data.repositories

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.nickoperea.inventariapp.data.databases.dao.ProductDao
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.utils.PRODUCT_TABLE_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProductRepository(
    val dataSource: ProductMock,
    private val dataSourceDb: ProductDao,
    private val dataSourceFirebaseStorage: FirebaseFirestore
) {
    val db: CollectionReference = dataSourceFirebaseStorage.collection(PRODUCT_TABLE_NAME)

    suspend fun loadProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val snapshot = db.get().await()
            snapshot.toObjects(Product::class.java)
        }
    }

    suspend fun insertProducts(products: List<Product>) {
        withContext(Dispatchers.IO) {
            val temp = dataSourceDb.getAllProducts()
            if (temp.isEmpty()) {
                dataSourceDb.insertProducts(products)
            }
        }
    }
}