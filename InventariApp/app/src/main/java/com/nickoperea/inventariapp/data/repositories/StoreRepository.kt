package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.databases.dao.StoreDao
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import com.nickoperea.inventariapp.data.models.StoreInfo

class StoreRepository(val dataSource: StoreInfoMock, private val dataSourceDb: StoreDao) {
    suspend fun loadInfo(): StoreInfo? {
//        return dataSource.loadStoreInfo()
        return dataSourceDb.getStore()
    }

    suspend fun insertInfo(storeInfo: StoreInfo) {
        val temp = dataSourceDb.getStore()
        if (temp == null) {
            dataSourceDb.insertStore(storeInfo)
        }
    }
}