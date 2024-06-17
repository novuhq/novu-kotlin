package co.novu.dto.response

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class NotificationGroupsResponse(
    @SerializedName("_id")
    var id: String? = null,
    var name: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_parentId")
    var parentId: String? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    @SerializedName("__v")
    var version: BigInteger? = null,
)
