package co.novu.dto.response

data class NotificationResponse(
    var _id: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var transactionId: String? = null,
    var createdAt: String? = null,
    var channels: String? = null
)
