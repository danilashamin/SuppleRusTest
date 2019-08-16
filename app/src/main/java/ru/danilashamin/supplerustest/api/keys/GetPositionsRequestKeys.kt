package ru.danilashamin.supplerustest.api.keys

import com.google.gson.annotations.SerializedName

data class GetPositionsRequestKeys(@SerializedName("prj_ID") val projectId: String, @SerializedName("grp_ID") val groupId: String = "")
