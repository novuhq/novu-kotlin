package dto.request

data class UpdateOrganizationBrandRequest(
    var logo: String? = null,
    var color: String? = null,
    var fontColor: String? = null,
    var contentBackground: String? = null,
    var fontFamily: String? = null,
)
