package com.nickoperea.inventariapp.data.repositories

import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import com.nickoperea.inventariapp.data.models.StoreInfo

class StoreRepository(val dataSource: StoreInfoMock) {
    suspend fun loadData(): StoreInfo {
        return dataSource.loadData()
    }
}