package co.novu.dto.request

data class MarkSubscriberFeedAsRequest(
    val messageId: Any, // Can be either a String or an Array of Strings
    val mark: Mark
)

data class Mark(val read: Boolean, val seen: Boolean)
