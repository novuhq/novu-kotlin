package co.novu.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class User(
    @SerializedName("_id")
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var profilePicture: String? = null,
    var showOnboarding: Boolean? = null,
    var token: List<Token>,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    @SerializedName("__v")
    var version: BigDecimal? = null,
)
