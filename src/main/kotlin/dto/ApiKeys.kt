package co.novu.dto

import com.google.gson.annotations.SerializedName

data class ApiKeys(
    var key: String? = null,
    @SerializedName("_userId")
    var userId: String? = null
)
