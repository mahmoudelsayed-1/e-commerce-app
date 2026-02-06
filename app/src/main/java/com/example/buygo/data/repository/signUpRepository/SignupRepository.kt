package com.example.buygo.data.repository.signUpRepository

import com.example.buygo.data.api.auth.register.SignupResponse

interface SignupRepository {

    suspend fun signUp(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?
    ): SignupResponse
}