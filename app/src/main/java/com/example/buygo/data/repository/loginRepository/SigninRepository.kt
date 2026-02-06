package com.example.buygo.data.repository.loginRepository

import com.example.buygo.data.api.auth.login.LoginResponse

interface SigninRepository {

    suspend fun signIn(email: String?, password: String?): LoginResponse

}


