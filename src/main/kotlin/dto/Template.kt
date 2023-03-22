package co.novu.dto

data class Template(
    var _id: String? = null,
    var name: String? = null,
    var critical: Boolean? = null,
    var triggers: List<Trigger>? = null
)
