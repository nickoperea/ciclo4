package com.nickoperea.inventariapp.data.mockups

import com.nickoperea.inventariapp.data.models.StoreInfo

class StoreInfoMock {
    fun loadStoreInfo(): StoreInfo {
        return StoreInfo(
            1,
            "InventariApp",
            "https://d1nhio0ox7pgb.cloudfront.net/_img/g_collection_png/standard/512x512/store.png",
            "Avenida Falsa # 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                    "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                    "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                    "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
                    "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
        )
    }
}