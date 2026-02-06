package com.example.buygo.data.repository.loginRepository

import com.example.buygo.data.api.auth.login.LoginResponse
import com.example.buygo.data.dataSource.loginDataSource.SigninDataSource

class SigninRepositoryImpl(private val onlineDataSource: SigninDataSource) : SigninRepository {
    override suspend fun signIn(email: String?, password: String?): LoginResponse {
        val response = onlineDataSource.signIn(
            email,
            password
        )
        onlineDataSource.saveToken(response.token ?: "")
        return response

    }

    suspend fun getSavedToken(): String? {
        return onlineDataSource.getToken()
    }
}