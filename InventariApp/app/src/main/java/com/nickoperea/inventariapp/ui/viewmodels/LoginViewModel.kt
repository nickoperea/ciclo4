package com.nickoperea.inventariapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.nickoperea.inventariapp.data.repositories.UserRepository

class LoginViewModel(private val repo: UserRepository): ViewModel() {
    private var user: MutableLiveData<FirebaseUser?> = MutableLiveData()
    val user : LiveData<FirebaseUser?> get() = user

    private var error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = error
}

