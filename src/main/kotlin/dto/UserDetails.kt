package dto

import com.google.gson.annotations.SerializedName

data class UserDetails(
    @SerializedName("_id")
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
)
