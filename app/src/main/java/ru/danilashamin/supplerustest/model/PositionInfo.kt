package ru.danilashamin.supplerustest.model

import com.google.gson.annotations.SerializedName

data class PositionInfo(
    @SerializedName("PositionID") val positionId: String,
    @SerializedName("Content") val content: Content
)

data class Content(
    @SerializedName("Title") val title: String,
    @SerializedName("ImageID") val imageId: String,
    @SerializedName("Description") val description: String
)