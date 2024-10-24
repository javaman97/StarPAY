package com.brian.myapplication.utils

import android.content.Context

class AuthPreferences(context: Context) {
    private val preferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveEmail(email: String) {
        preferences.edit().putString("user_email", email).apply()
    }

    fun getUserEmail(): String? {
        return preferences.getString("user_email", null)
    }

    fun savePassword(password: String) {
        preferences.edit().putString("user_password", password).apply()
    }

    fun getUserPassword(): String? {
        return preferences.getString("user_password", null)
    }

    fun saveUser(email: String, password: String){
        saveEmail(email)
        savePassword(password)
    }

    fun clearUser() {
        preferences.edit().remove("user_email").apply()
        preferences.edit().remove("user_password").apply()
    }

    fun isAuthenticated(): Boolean {
        return getUserEmail() != null
    }
}
