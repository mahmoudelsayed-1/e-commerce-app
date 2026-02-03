package com.example.buygo.data.repository

import com.example.buygo.data.api.SignupResponse
import com.example.buygo.data.dataSource.SignupDataSource
import com.example.buygo.repository.signUpRepository.SignupRepository

class SignupRepositoryImpl(private val dataSource: SignupDataSource):SignupRepository {
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