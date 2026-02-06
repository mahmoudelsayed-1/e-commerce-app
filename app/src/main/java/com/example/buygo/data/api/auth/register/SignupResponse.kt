package com.example.buygo.data.api.auth.register

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignupResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("token")
    val token: String? = null
) : Parcelable