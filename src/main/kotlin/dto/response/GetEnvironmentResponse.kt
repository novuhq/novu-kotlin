package co.novu.dto.response

import co.novu.dto.ApiKeys
import co.novu.dto.Widget
import java.math.BigDecimal

data class GetEnvironmentResponse(
    var _id: String? = null,
    var name: String? = null,
    var identifier: String? = null,
    var _organizationId: String? = null,
    var apiKeys: List<ApiKeys>? = null,
    var widget: Widget? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var _parentId: String? = null,
    var __v: BigDecimal? = null

)
