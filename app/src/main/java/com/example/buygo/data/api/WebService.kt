package com.example.buygo.data.api

import com.example.buygo.data.api.auth.login.LoginResponse
import com.example.buygo.data.api.auth.login.SignInRequest
import com.example.buygo.data.api.auth.register.SignupRequest
import com.example.buygo.data.api.auth.register.SignupResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface WebService {

    @POST("api/v1/auth/signup")
    suspend fun signUp(
        @Body requestRegister: SignupRequest
    ): SignupResponse

    @POST("api/v1/auth/signin")
    suspend fun signIn(
        @Body requestLogin: SignInRequest
    ): LoginResponse


}