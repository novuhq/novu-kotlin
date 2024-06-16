package co.novu.dto.response

import java.math.BigInteger

data class NotificationStatsResponse(
    var weeklySent: BigInteger? = null,
    var monthlySent: BigInteger? = null,
    var yearlySent: BigInteger? = null,
)
