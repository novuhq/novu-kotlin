package co.novu.dto.response

import java.math.BigInteger

data class NotificationStatsResponse(
    var weeklySent: BigInteger,
    var monthlySent: BigInteger,
    var yearlySent: BigInteger
)
