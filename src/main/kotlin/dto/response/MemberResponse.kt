package dto.response

import com.google.gson.annotations.SerializedName
import dto.InviteDetails
import dto.UserDetails

data class MemberResponse(
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_userId")
    var userId: String? = null,
    var user: UserDetails? = null,
    var roles: List<String>? = null,
    var invite: InviteDetails? = null,
    var memberStatus: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
)
