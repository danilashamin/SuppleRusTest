package ru.danilashamin.supplerustest.model

import com.google.gson.annotations.SerializedName

data class ProjectInfo(
    @SerializedName("prj_id") val projectId: String,
    @SerializedName("prgr_Name") val projectName: String
)