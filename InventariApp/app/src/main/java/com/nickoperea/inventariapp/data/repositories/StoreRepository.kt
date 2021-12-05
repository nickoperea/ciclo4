package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.StoreDao
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import com.nickoperea.inventariapp.data.models.StoreInfo

class StoreRepository(private val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao) {
    suspend fun loadInfo(): StoreInfo? {
//        return dataSource.loadData()
        return dataSourceDb.getStore()
    }
    suspend fun insertInfo(store: StoreInfo) {
        val temp = dataSourceDb.getStore()
        if(temp == null) {
            dataSourceDb.insertStore(store)
        }
    }
}