package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Notification(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_templateId")
    val templateId: String? = null,
    @SerializedName("_environmentId")
    val environmentId: String? = null,
    @SerializedName("_organizationId")
    val organizationId: String? = null,
    @SerializedName("_subscriberId")
    val subscriberId: String? = null,
    val transactionId: String? = null,
    val channels: List<String>? = null,
    val to: Subscriber? = null,
    val payload: Any? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val template: Template? = null,
    val subscriber: Subscriber? = null,
    val jobs: List<Job>? = null,
)
