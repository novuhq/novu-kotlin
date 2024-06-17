package co.novu.dto.response

import co.novu.dto.Credential
import com.google.gson.annotations.SerializedName

data class IntegrationResponse(
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    var providerId: String? = null,
    var channel: String? = null,
    var credentials: Credential? = null,
    var active: Boolean? = null,
    var deleted: Boolean? = null,
    var deletedAt: String? = null,
    var deletedBy: String? = null,
    var primary: Boolean? = null,
)
