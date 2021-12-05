package com.nickoperea.inventariapp.data.repositories

import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.coroutines.tasks.await

class UserRepository(private val dataSource: FirebaseAuth) {
    suspend fun loggedIn(): FirebaseUser? {
        return dataSource.currentUser
    }

    suspend fun signUp(email: String, name: String, password: String): FirebaseUser {
        try {
            dataSource.createUserWithEmailAndPassword(email, password).await()
            val user = dataSource.currentUser
            val profileUpdate = userProfileChangeRequest {
                displayName = name
            }
            user!!.updateProfile(profileUpdate).await()
            return user
        } catch (e: FirebaseAuthUserCollisionException) {
            throw Error("Correo electrónico en uso.")
        }
    }

    suspend fun logIn(email: String, password: String): FirebaseUser? {
        try {
            dataSource.signInWithEmailAndPassword(email, password).await()
            return dataSource.currentUser
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw Error("Credenciales inválidas")
        } catch (e: FirebaseAuthInvalidUserException) {
            throw Error("Usuario inválido")
        }
    }

    suspend fun logOut(): FirebaseUser? {
        dataSource.signOut()
        return null
    }
}