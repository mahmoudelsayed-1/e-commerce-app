package com.example.buygo.data.api

import retrofit2.http.Body
import retrofit2.http.POST

interface WebService {

    @POST("api/v1/auth/signup")
    suspend fun signUp(
        @Body request: SignupRequest
    ): SignupResponse
}