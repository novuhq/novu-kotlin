package co.novu.dto.request

data class MarkMessageActionAsSeenRequest(
    var status: String?,
    var payload: Any? = null
)
