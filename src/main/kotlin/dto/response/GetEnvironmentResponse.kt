package co.novu.dto.response

import co.novu.dto.ApiKeys
import co.novu.dto.Widget
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class GetEnvironmentResponse(
    @SerializedName("_id")
    var id: String? = null,
    var name: String? = null,
    var identifier: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    var apiKeys: List<ApiKeys>? = null,
    var widget: Widget? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    @SerializedName("_parentId")
    var parentId: String? = null,
    @SerializedName("__v")
    var version: BigDecimal? = null,
)
