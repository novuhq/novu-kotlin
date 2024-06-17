package co.novu.dto

import java.math.BigInteger

data class Metadata(
    val amount: BigInteger? = null,
    val unit: String? = null,
    val digestKey: String? = null,
    val delayPath: String? = null,
    val type: String? = null,
    val backoffUnit: String? = null,
    val backoffAmount: BigInteger? = null,
    val updateMode: Boolean? = null,
)
