package co.novu.dto.response.integrations

import co.novu.dto.Credential

data class IntegrationReponse(
    var _id: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var providerId: String? = null,
    var channel: String? = null,
    var credential: Credential? = null,
    var active: Boolean? = null,
    var deleted: Boolean? = null,
    var deletedAt: String? = null,
    var deletedBy: String? = null
)
