package co.novu.dto.response.events

data class TriggerResponse(
    var acknowledged: Boolean,
    var status: String,
    var transactionId: String? = null,
    var error: List<Any>? = null
)
