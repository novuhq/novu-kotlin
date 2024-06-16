package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Variables(
    var name: String? = null,
    @SerializedName("_id")
    var id: String? = null,
)
