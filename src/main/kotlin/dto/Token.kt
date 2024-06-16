package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("_id")
    var id: String? = null,
    var providerId: String? = null,
    var provider: String? = null,
    var accessToken: String? = null,
    var valid: Boolean? = null,
)
