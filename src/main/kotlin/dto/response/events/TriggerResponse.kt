package co.novu.dto.response.events

data class TriggerResponse(
    var acknowledged: Boolean? = null,
    var status: String? = null,
    var transactionId: String? = null,
    var error: List<Any>? = null
)
