package co.novu.dto.request

data class TenantRequest(
    private var identifier: String? = null,
    private var name: String? = null,
    private var data: Any? = null
)
