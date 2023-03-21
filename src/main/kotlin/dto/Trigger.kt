package co.novu.dto

data class Trigger(
    val type: String,
    val identifier: String,
    val variables: List<Variables>,
    val subscriberVariables: List<Variables>
)
