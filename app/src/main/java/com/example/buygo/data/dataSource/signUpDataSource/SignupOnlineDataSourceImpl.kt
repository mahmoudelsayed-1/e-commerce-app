package com.example.buygo.data.dataSource.signUpDataSource

import com.example.buygo.data.api.WebService
import com.example.buygo.data.api.auth.register.SignupRequest
import com.example.buygo.data.api.auth.register.SignupResponse

class SignupOnlineDataSourceImpl(private val webService: WebService) : SignupDataSource {
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