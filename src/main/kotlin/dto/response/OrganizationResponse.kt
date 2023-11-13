package dto.response

import dto.Branding
import dto.PartnerConfigurations

data class OrganizationResponse(
    var name: String? = null,
    var logo: String? = null,
    var branding: Branding? = null,
    var partnerConfigurations: List<PartnerConfigurations>? = null
)
