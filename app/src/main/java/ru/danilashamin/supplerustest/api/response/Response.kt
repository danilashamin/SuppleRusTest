package ru.danilashamin.supplerustest.api.response

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("ErrorCode") val errorCode: Int,
    @SerializedName("UserErrorInfo") val userErrorInfo: String,
    @SerializedName("ErrorInfo") val errorInfo: String,
    @SerializedName("Body") val body: T
)