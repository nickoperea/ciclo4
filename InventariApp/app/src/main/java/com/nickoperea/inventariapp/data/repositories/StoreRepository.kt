package com.nickoperea.inventariapp.data.repositories

class StoreRepositorie {private val dataSource: StoreInfoMock}{
    suspend fun loadInfo(): StoreInfo{
        return dataSource.loadInfo()
    }
}