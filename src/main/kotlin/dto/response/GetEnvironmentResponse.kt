package co.novu.dto.response

import co.novu.dto.ApiKeys
import co.novu.dto.Widget

data class GetEnvironmentResponse(
    var _id: String,
    var name: String,
    var _organizationId: String,
    var identifier: String,
    var apiKeys: List<ApiKeys>,
    var widget: Widget,
    var _parentId: String

)
