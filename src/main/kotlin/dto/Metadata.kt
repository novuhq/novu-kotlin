package co.novu.dto

import java.math.BigInteger

data class Metadata(
    val amount: BigInteger,
    val unit: String,
    val digestKey: String,
    val delayPath: String,
    val type: String,
    val backoffUnit: String,
    val backoffAmount: BigInteger,
    val updateMode: Boolean
)
