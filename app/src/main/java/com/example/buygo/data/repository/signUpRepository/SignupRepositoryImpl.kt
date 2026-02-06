package com.example.buygo.data.repository.signUpRepository

import com.example.buygo.data.api.auth.register.SignupResponse
import com.example.buygo.data.dataSource.signUpDataSource.SignupDataSource

class SignupRepositoryImpl(private val dataSource: SignupDataSource) : SignupRepository {
    override suspend fun signUp(
        name: String?,
        email: String?,
        password: String?,
        rePassword: String?,
        phone: String?
    ): SignupResponse {
        return dataSource.signUpDataSource(
            name,
            email,
            password,
            rePassword,
            phone
        )
    }
}