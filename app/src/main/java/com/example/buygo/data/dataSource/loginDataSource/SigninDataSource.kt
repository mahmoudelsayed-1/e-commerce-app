package com.example.buygo.data.dataSource.loginDataSource

import com.example.buygo.data.api.auth.login.LoginResponse

interface SigninDataSource {

    suspend fun signIn(
        email: String?,
        password: String?
    ): LoginResponse

    suspend fun saveToken(token: String)
    suspend fun getToken(): String?
    suspend fun clearToken()
}