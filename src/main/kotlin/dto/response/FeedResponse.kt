package co.novu.dto.response

import java.math.BigDecimal

data class FeedResponse(
    var _id: String? = null,
    var name: String? = null,
    var identifier: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var updatedAt: String? = null,
    var createdAt: String? = null,
    var __v: BigDecimal? = null,
    var deleted: Boolean? = null
)
