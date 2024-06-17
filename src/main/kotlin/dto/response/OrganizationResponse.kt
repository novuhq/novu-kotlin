package dto.response

import com.google.gson.annotations.SerializedName
import dto.Branding
import dto.PartnerConfigurations

data class OrganizationResponse(
    @SerializedName("_id")
    var id: String? = null,
    var name: String? = null,
    var logo: String? = null,
    var branding: Branding? = null,
    var partnerConfigurations: List<PartnerConfigurations>? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    @SerializedName("__v")
    var version: Long? = null,
)
