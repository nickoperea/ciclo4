package com.nickoperea.inventariapp.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.nickoperea.inventariapp.data.mockups.CommentMock
import com.nickoperea.inventariapp.data.mockups.ProductMock
import com.nickoperea.inventariapp.data.mockups.StoreInfoMock
import org.koin.dsl.module

val dataSourceModule = module {
    single { CommentMock() }
    single { ProductMock() }
    single { StoreInfoMock() }
    single { FirebaseAuth.getInstance() }
    single { FirebaseStorage.getInstance().getReference() }
    single { FirebaseFirestore.getInstance() }
}