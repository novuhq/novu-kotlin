package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class CreateLayoutResponse(
    @SerializedName("_id")
    var id: String? = null,
)
