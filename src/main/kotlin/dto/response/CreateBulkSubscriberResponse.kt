package co.novu.dto.response

data class CreateBulkSubscriberResponse(
    var updated: List<String>? = null,
    var created: List<String>? = null,
    var failed: List<FailedRequest>? = null,
)

data class FailedRequest(
    var message: String? = null,
    var subscriberId: String? = null,
)
