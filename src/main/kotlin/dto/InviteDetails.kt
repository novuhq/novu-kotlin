package dto

import com.google.gson.annotations.SerializedName

data class InviteDetails(
    var email: String? = null,
    var token: String? = null,
    var invitationDate: String? = null,
    var answerDate: String? = null,
    @SerializedName("_inviterId")
    var inviterId: String? = null,
)
