package co.novu.dto.response

data class TriggerResponse(
    var acknowledged: Boolean? = null,
    var status: String? = null,
    var transactionId: String? = null,
    var error: List<String>? = null,
)
