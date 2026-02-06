package com.example.buygo.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    val retrofit: Retrofit? = null

    fun getInstance(): Retrofit {
        if (retrofit == null) {
            return Retrofit.Builder()
                .baseUrl("https://ecommerce.routemisr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getApi(): WebService {
        return getInstance().create(WebService::class.java)

    }
}