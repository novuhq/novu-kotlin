package co.novu.dto

data class Notification(
    val _id: String? = null,
    val _templateId: String? = null,
    val _environmentId: String? = null,
    val _organizationId: String? = null,
    val _subscriberId: String? = null,
    val transactionId: String? = null,
    val channels: List<String>? = null,
    val to: Subscriber? = null,
    val payload: Any? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val template: Template? = null,
    val subscriber: Subscriber? = null,
    val jobs: List<Job>? = null
)
