package co.novu.dto

import com.google.gson.annotations.SerializedName

data class NotificationGroup(
    @SerializedName("_id")
    val id: String? = null,
    val name: String? = null,
    @SerializedName("_organizationId")
    val organizationId: String? = null,
    @SerializedName("_environmentId")
    val environmentId: String? = null,
    @SerializedName("_parentId")
    val parentId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    @SerializedName("__v")
    val version: String? = null
)
