package co.novu.dto.response

import co.novu.dto.User
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class ChangesResponse(
    @SerializedName("_id")
    var id: String? = null,
    var enabled: Boolean? = null,
    var type: String? = null,
    var change: Any? = null,
    @SerializedName("_creatorId")
    var creatorId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_entityId")
    var entityId: String? = null,
    @SerializedName("__v")
    var version: BigDecimal? = null,
    var user: User? = null,
    var templateName: String? = null,
    var createdAt: String? = null,
    @SerializedName("_parentId")
    var parentId: String? = null
)
