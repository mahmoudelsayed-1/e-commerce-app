package com.example.buygo.data.api

data class SignupRequest(
    val name: String?=null,
    val email: String?=null,
    val password: String?=null,
    val rePassword: String?=null,
    val phone: String?=null,
)
