package co.novu.dto.response

data class RemoveSubscriberResponse(
    val acknowledged: Boolean = true,
    val status: String = "Done"
)