package co.novu.dto.response.integrations

import co.novu.dto.Credential

data class IntegrationReponse(
    var _id: String,
    var _environmentId: String,
    var _organizationId: String,
    var providerId: String,
    var channel: String,
    var credential: Credential,
    var active: Boolean,
    var deleted: Boolean,
    var deletedAt: String,
    var deletedBy: String
)
