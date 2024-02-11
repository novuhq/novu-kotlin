package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class GetLayoutsResponse(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_creatorId")
    val creatorId: String? = null,
    val name: String? = null,
    val description: String? = null,
    val channel: String? = null,
    val content: String? = null,
    val contentType: String? = null,
    val variables: List<Any>? = null,
    val isDefault: Boolean? = null,
    val isDeleted: Boolean? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    @SerializedName("_parentId")
    val parentId: String? = null
)
