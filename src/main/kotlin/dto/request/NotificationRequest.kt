package co.novu.dto.request

import java.math.BigInteger

data class NotificationRequest(
    var channels: List<String>?,
    var templates: List<String>?,
    var emails: List<String>?,
    var search: String?,
    var page: BigInteger? = null,
    var transactionId: String? = null
)
