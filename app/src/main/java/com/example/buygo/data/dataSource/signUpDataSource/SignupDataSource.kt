package com.example.buygo.data.dataSource.signUpDataSource

import com.example.buygo.data.api.auth.register.SignupResponse

interface SignupDataSource {

    suspend fun signUpDataSource(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?
    ): SignupResponse
}