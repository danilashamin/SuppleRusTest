package ru.danilashamin.supplerustest.api.request

import com.google.gson.annotations.SerializedName

/**
 * @param T - key generic type
 */
data class Request<T>(
    @SerializedName("Keys") val keys: T,
    @SerializedName("ObjectID") val objectId: String = "",
    @SerializedName("UserToken") val userToken: String = ""
)