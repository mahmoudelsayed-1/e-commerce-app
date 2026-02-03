package com.example.buygo.data.dataSource

import com.example.buygo.data.api.SignupRequest
import com.example.buygo.data.api.SignupResponse
import com.example.buygo.data.api.WebService

class SignupOnlineDataSourceImpl(private val webService: WebService):SignupDataSource {
    override suspend fun signUpDataSource(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?,
    ): SignupResponse {
        return webService.signUp(
            SignupRequest(name, email, password, rePassword, phone)
        )
    }
}