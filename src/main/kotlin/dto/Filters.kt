package co.novu.dto

data class Filters(
    val isNegated: Boolean,
    val type: Boolean,
    val value: String,
    val children: List<Children>
)
