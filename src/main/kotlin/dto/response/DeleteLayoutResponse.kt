package co.novu.dto.response

data class DeleteLayoutResponse(
    val acknowledged: Boolean = true,
    val status: String = "Done",
)
