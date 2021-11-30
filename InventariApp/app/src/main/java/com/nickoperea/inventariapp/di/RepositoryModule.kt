package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.data.repositories.CommentRepository
import com.nickoperea.inventariapp.data.repositories.ProductRepository
import com.nickoperea.inventariapp.data.repositories.StoreRepository
import org.koin.dsl.module

val repoModule = module {
    single { StoreRepository(get()) }
    single { ProductRepository(get()) }
    single { CommentRepository(get()) }
}