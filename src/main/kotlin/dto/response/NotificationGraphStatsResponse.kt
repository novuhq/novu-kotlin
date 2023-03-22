package co.novu.dto.response

import java.math.BigInteger

data class NotificationGraphStatsResponse(
    var _id: String? = null,
    var count: BigInteger? = null,
    var templates: List<String>? = null,
    var channels: List<Any>? = null
)
