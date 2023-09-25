package co.novu.dto

data class Trigger(
    val type: String? = null,
    val _id: String? = null,
    val identifier: String? = null,
    val variables: List<Variables>? = null,
    val subscriberVariables: List<Variables>? = null,
    val reservedVariables: List<Variables>? = null
)
