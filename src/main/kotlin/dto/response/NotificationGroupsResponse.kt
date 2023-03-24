package co.novu.dto.response

import java.math.BigInteger

data class NotificationGroupsResponse(
    var _id: String? = null,
    var name: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var _parentId: String? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var __v: BigInteger? = null,
)
