package co.novu.dto

data class Step(
    val _id: String? = null,
    val _templateId: String? = null,
    val uuid: String? = null,
    val name: String? = null,
    val active: Boolean? = null,
    val shouldStopOnFail: Boolean? = null,
    val template: Any? = null,
    val filters: List<Filters>? = null,
    val _parentId: String? = null,
    val metadata: Metadata? = null,
    val replyCallback: Any? = null
)
