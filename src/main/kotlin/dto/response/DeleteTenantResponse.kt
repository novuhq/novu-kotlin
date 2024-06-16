package co.novu.dto.response

data class DeleteTenantResponse(
    val acknowledged: Boolean = true,
    val status: String = "Done",
)
