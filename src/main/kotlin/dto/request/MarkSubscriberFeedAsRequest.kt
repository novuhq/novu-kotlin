package co.novu.dto.request

data class MarkSubscriberFeedAsRequest(
    val messageId: String,
    val mark: Mark,
)

data class Mark(val read: Boolean, val seen: Boolean)
