package com.nickoperea.inventariapp.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nickoperea.inventariapp.data.databases.dao.CommentDao
import com.nickoperea.inventariapp.data.databases.dao.ProductDao
import com.nickoperea.inventariapp.data.databases.dao.StoreDao
import com.nickoperea.inventariapp.data.models.Comment
import com.nickoperea.inventariapp.data.models.Product
import com.nickoperea.inventariapp.data.models.StoreInfo

@Database(
    entities = [
        Comment::class,
        Product::class,
        StoreInfo::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun commendDao(): CommentDao
    abstract fun productDao(): ProductDao
    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "inventariapp.db")
                        .build()
                }
            }
            return instance!!
        }
    }
}