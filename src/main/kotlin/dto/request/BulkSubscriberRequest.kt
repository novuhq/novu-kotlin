package co.novu.dto.request

data class BulkSubscriberRequest(
    val subscribers: List<SubscriberRequest>? = null
)
