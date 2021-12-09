package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { StoreViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { CommentViewModel(get()) }
    viewModel { SplashViewModel(get(), get(), get()) }
    viewModel { LoginViewModel(get()) }
}