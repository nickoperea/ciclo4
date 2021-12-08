package com.nickoperea.inventariapp.data.mockups

import com.nickoperea.inventariapp.data.models.StoreInfo

class StoreInfoMock {
    fun loadStoreInfo(): StoreInfo {
        return StoreInfo(
            1,
            "InventariApp",
            "https://d1nhio0ox7pgb.cloudfront.net/_img/g_collection_png/standard/512x512/store.png",
            "Avenida Falsa # 123",
            "¡Bienvenido!. A través de nuestra APP puedes adquirir nuestros mejores productos"
        )
    }
}