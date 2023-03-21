package co.novu.dto

data class Step(
    val _id: String,
    val _templateId: String,
    val active: Boolean,
    val shouldStopOnFail: Boolean,
    val template: Any,
    val filters: List<Filters>,
    val _parentId: String,
    val metadata: Metadata,
    val replyCallback: Any
)
