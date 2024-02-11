package co.novu.dto.response

import co.novu.dto.Job
import co.novu.dto.Subscriber
import co.novu.dto.Template
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Message(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_templateId")
    val templateId: String? = null,
    @SerializedName("_environmentId")
    val environmentId: String? = null,
    @SerializedName("_messageTemplateId")
    val messageTemplateId: String? = null,
    val notificationId: String? = null,
    @SerializedName("_organizationId")
    val organizationId: String? = null,
    @SerializedName("_subscriberId")
    val subscriberId: String? = null,
    @SerializedName("_jobId")
    val jobId: String? = null,
    val templateIdentifier: String? = null,
    val email: String? = null,
    val subject: String? = null,
    val cta: Any? = null,
    val channels: String? = null,
    val content: String? = null,
    val providerId: String? = null,
    val deviceTokens: List<String>? = null,
    val seen: Boolean? = null,
    val read: Boolean? = null,
    val status: String? = null,
    val transactionId: String? = null,
    val payload: Any? = null,
    val deleted: Boolean? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    @SerializedName("__v")
    val version: BigDecimal? = null,
    val identifier: String? = null,
    val subscriber: Subscriber? = null,
    val template: Template? = null,
    val jobs: List<Job>? = null
)
