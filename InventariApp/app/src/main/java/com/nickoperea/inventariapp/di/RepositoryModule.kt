package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.data.repositories.CommentRepository
import com.nickoperea.inventariapp.data.repositories.ProductRepository
import com.nickoperea.inventariapp.data.repositories.StoreRepository
import com.nickoperea.inventariapp.data.repositories.UserRepository
import org.koin.dsl.module

val repoModule = module {
    single { StoreRepository(get(), get(), get()) }
    single { ProductRepository(get(), get(), get()) }
    single { CommentRepository(get(), get(), get()) }
    single { UserRepository(get(), get()) }
}