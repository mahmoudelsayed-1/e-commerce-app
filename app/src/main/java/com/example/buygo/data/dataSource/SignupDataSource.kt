package com.example.buygo.data.dataSource

import com.example.buygo.data.api.SignupResponse

interface SignupDataSource {

    suspend fun signUpDataSource(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?
    ): SignupResponse
}