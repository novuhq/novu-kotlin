package co.novu.dto.blueprints

data class Step(
    val _id: String? = null,
    val _templateId: String? = null,
    val uuid: String? = null,
    val name: String? = null,
    val active: Boolean? = null,
    val shouldStopOnFail: Boolean? = null,
    val template: Any? = null,
    val filters: Any? = null,
    val _parentId: String? = null,
    val metadata: Any? = null,
    val replyCallback: Any? = null
)
