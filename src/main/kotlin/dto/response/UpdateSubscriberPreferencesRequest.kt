package co.novu.dto.response

data class UpdateSubscriberPreferencesRequest(
    var channel: Any? = null,
    var enabled: Boolean? = null
)
