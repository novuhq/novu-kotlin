package co.novu.dto.response.subscribers

data class SubscriberDeleteResponse(
    var acknowledged: Boolean,
    var status: String
)