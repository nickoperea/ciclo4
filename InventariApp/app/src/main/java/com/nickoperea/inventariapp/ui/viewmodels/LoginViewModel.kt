package com.nickoperea.inventariapp.ui.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.nickoperea.inventariapp.data.repositories.UserRepository
import kotlinx.coroutines.launch
import java.lang.Error

class LoginViewModel(private val repo: UserRepository): ViewModel() {
    private var _user: MutableLiveData<FirebaseUser?> = MutableLiveData()
    val user : LiveData<FirebaseUser?> get() = _user

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    fun signUp(email: String, name: String, password: String){
        viewModelScope.launch {
            try {
                _user.postValue(repo.signUp(email, name, password))
            }catch (e: Error){
                _error.postValue(e.message)
            }
        }
    }

    fun logIn(email: String, password: String){
        viewModelScope.launch {
            try {
                _user.postValue(repo.logIn(email, password))
            }catch (e: Error){
                _error.postValue(e.message)
            }
        }
    }

    fun logOut(){
        viewModelScope.launch {
            _user.postValue(repo.logOut())
        }
    }

    fun loggedIn(){
        viewModelScope.launch {
            _user.postValue(repo.logOut())
        }
    }

    fun uploadImage(bitmap: Bitmap) {
        viewModelScope.launch {
            _user.postValue(repo.uploadImage(bitmap))
        }
    }
}
