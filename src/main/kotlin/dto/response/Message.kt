package co.novu.dto.response

import co.novu.dto.Job
import co.novu.dto.Subscriber
import co.novu.dto.Template
import java.math.BigDecimal

data class Message(
    val _id: String? = null,
    val _templateId: String? = null,
    val _environmentId: String? = null,
    val _messageTemplateId: String? = null,
    val notificationId: String? = null,
    val _organizationId: String? = null,
    val _subscriberId: String? = null,
    val _jobId: String? = null,
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
    val __v: BigDecimal? = null,
    val identifier: String? = null,
    val subscriber: Subscriber? = null,
    val template: Template? = null,
    val jobs: List<Job>? = null
)
