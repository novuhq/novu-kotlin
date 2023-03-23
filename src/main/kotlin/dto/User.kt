package co.novu.dto

import java.math.BigDecimal

data class User(
    var _id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var profilePicture: String? = null,
    var showOnboarding: Boolean? = null,
    var token: List<Token>,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var __v: BigDecimal? = null

)
