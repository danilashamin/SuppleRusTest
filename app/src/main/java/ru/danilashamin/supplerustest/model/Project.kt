package ru.danilashamin.supplerustest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Project(
    @SerializedName("prj_id") val projectId: String,
    @SerializedName("prgr_Name") val projectName: String
) : Serializable