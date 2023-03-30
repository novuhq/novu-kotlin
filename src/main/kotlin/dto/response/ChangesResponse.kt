package co.novu.dto.response

import co.novu.dto.User
import java.math.BigDecimal

data class ChangesResponse(
    var _id: String? = null,
    var enabled: Boolean? = null,
    var type: String? = null,
    var change: Any? = null,
    var _creatorId: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var _entityId: String? = null,
    var __v: BigDecimal? = null,
    var user: User? = null,
    var templateName: String? = null,
    var createdAt: String? = null,
    var _parentId: String? = null
)
