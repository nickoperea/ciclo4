package com.nickoperea.inventariapp.di

import com.nickoperea.inventariapp.ui.viewmodels.CommentViewModel
import com.nickoperea.inventariapp.ui.viewmodels.ProductViewModel
import com.nickoperea.inventariapp.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { StoreViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { CommentViewModel(get()) }
}