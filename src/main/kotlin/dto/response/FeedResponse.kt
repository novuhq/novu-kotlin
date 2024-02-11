package co.novu.dto.response

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class FeedResponse(
    @SerializedName("_id")
    var id: String? = null,
    var name: String? = null,
    var identifier: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    var updatedAt: String? = null,
    var createdAt: String? = null,
    @SerializedName("__v")
    var version: BigDecimal? = null,
    var deleted: Boolean? = null
)
