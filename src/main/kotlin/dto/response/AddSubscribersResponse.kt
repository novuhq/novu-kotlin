package co.novu.dto.response

data class AddSubscribersResponse(
    var succeeded: List<String>? = null,
    var failed: Failed? = null,
)

data class Failed(
    var notFound: List<String>? = null,
)
