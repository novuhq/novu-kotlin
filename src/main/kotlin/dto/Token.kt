package co.novu.dto

data class Token(
    var _id: String? = null,
    var providerId: String? = null,
    var provider: String? = null,
    var accessToken: String? = null,
    var valid: Boolean? = null
)
