package com.example.buygo.data.dataSource.loginDataSource

import android.content.Context
import com.example.buygo.data.api.WebService
import com.example.buygo.data.api.auth.login.LoginResponse
import com.example.buygo.data.api.auth.login.SignInRequest

class SigninOnlineDataSourceImpl(val webService: WebService, context: Context) : SigninDataSource {

    private val prefs = context.getSharedPreferences(
        "auth_prefs",
        0
    )

    override suspend fun signIn(email: String?, password: String?): LoginResponse {
        return webService.signIn(SignInRequest(email, password))
    }

    override suspend fun saveToken(token: String) {
        prefs.edit().putString("token", token).apply()
    }

    override suspend fun getToken(): String? {
        return prefs.getString("token", "")
    }

    override suspend fun clearToken() {
        prefs.edit().clear().apply()
    }
}