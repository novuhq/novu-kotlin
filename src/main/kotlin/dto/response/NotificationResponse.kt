package co.novu.dto.response

data class NotificationResponse(
    var _id: String,
    var _environmentId: String,
    var _organizationId: String,
    var transactionId: String,
    var createdAt: String,
    var channels: String,
)
