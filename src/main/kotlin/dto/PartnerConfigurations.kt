package dto

data class PartnerConfigurations(
    var projectIds: List<String>? = null,
    var accessToken: String? = null,
    var configurationId: String? = null,
    var teamId: String? = null,
    var partnerType: String? = null,
)
