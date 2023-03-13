package co.novu.dto.response

import java.math.BigInteger

data class NotificationGraphStatsResponse(
    var _id: String,
    var count: BigInteger,
    var templates: List<String>,
    var channels: List<Any>
)
