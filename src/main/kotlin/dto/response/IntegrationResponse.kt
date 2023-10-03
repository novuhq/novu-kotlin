package co.novu.dto.response

import co.novu.dto.Credential

data class IntegrationResponse(
    var _id: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var providerId: String? = null,
    var channel: String? = null,
    var credentials: Credential? = null,
    var active: Boolean? = null,
    var deleted: Boolean? = null,
    var deletedAt: String? = null,
    var deletedBy: String? = null,
    var primary: Boolean? = null
)
