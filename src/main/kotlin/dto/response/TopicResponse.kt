package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class TopicResponse(
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    var key: String? = null,
    var name: String? = null,
    var subscribers: List<String>? = null
)
