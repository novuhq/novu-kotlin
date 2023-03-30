package co.novu.dto.response

import co.novu.dto.Credential
import java.math.BigDecimal

data class IntegrationReponse(
    var _id: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var providerId: String? = null,
    var channel: String? = null,
    var credential: Credential? = null,
    var active: Boolean? = null,
    var deleted: Boolean? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var __v: BigDecimal? = null
)
