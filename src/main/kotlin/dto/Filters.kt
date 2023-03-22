package co.novu.dto

data class Filters(
    val isNegated: Boolean? = null,
    val type: String? = null,
    val value: String? = null,
    val children: List<Children>? = null
)
