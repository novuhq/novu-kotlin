package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class CreateTopicResponse(
    @SerializedName("_id")
    var id: String? = null,
    var key: String? = null,
)
