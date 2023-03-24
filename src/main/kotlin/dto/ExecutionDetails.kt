package co.novu.dto

data class ExecutionDetails(
    val _id: String? = null,
    val _jobId: String? = null,
    val _organizationId: String? = null,
    val _environmentId: String? = null,
    val _notificationId: String? = null,
    val _subscriberId: String? = null,
    val _notificationTemplateId: String? = null,
    val _messageId: String? = null,
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
