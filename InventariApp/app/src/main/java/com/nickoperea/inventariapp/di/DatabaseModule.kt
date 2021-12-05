package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.data.databases.AppDatabase
import com.nickoperea.inventariapp.data.databases.dao.CommentDao
import org.koin.dsl.module

val databaseModule = module {
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().commendDao() }
    single { get<AppDatabase>().productDao() }
    single { get<AppDatabase>().storeDao() }
}