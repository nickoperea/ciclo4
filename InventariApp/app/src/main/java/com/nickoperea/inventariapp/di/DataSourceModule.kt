package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import org.koin.dsl.module

val dataSourceModule = module {
    single { CommentMock() }
    single { ProductMock() }
    single { StoreInfoMock() }
}