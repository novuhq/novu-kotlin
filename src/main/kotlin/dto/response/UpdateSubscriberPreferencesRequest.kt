package co.novu.dto.response

data class UpdateSubscriberPreferencesRequest(
    var channel: Any,
    var enabled: Boolean,
)
