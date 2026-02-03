package com.example.buygo.repository.signUpRepository

import com.example.buygo.data.api.SignupResponse

interface SignupRepository {

    suspend fun signUp(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?
    ): SignupResponse
}