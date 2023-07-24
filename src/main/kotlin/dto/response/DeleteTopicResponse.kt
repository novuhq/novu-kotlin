package co.novu.dto.response

data class DeleteTopicResponse(
    val acknowledged: Boolean = true,
    val status: String = "Done"
)