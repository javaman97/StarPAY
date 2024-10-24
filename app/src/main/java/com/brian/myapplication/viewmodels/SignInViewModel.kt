package com.brian.myapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brian.myapplication.utils.AuthPreferences

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val authPreferences = AuthPreferences(application)

    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() {
        _isAuthenticated.value = authPreferences.isAuthenticated()
    }

    fun login(email: String, password:String) {
        authPreferences.saveUser(email, password )
        _isAuthenticated.value = true
    }

    fun logout() {
        authPreferences.clearUser()
        _isAuthenticated.value = false
    }

    fun authenticateWithPin(pin: String) {
        // Validate the PIN here
    }
}

