package co.novu.dto.response

import java.math.BigInteger

data class UnseenNotificationsCountResponse (
    var count: BigInteger? = 0.toBigInteger()
)