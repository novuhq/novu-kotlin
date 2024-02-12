package co.novu.dto

import com.google.gson.annotations.SerializedName

data class ExecutionDetails(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_jobId")
    val jobId: String? = null,
    @SerializedName("_organizationId")
    val organizationId: String? = null,
    @SerializedName("_environmentId")
    val environmentId: String? = null,
    @SerializedName("_notificationId")
    val notificationId: String? = null,
    @SerializedName("_subscriberId")
    val subscriberId: String? = null,
    @SerializedName("_notificationTemplateId")
    val notificationTemplateId: String? = null,
    @SerializedName("_messageId")
    val messageId: String? = null,
    val transactionId: String? = null,
    val providerId: Any? = null,
    val status: String? = null,
    val detail: String? = null,
    val isRetry: Boolean? = null,
    val isTest: Boolean? = null,
    val raw: Any? = null,
    val source: String? = null,
    val createdAt: String? = null,
    var updatedAt: String? = null
)
