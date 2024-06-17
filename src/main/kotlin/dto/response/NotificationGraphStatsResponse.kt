package co.novu.dto.response

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class NotificationGraphStatsResponse(
    @SerializedName("_id")
    var id: String? = null,
    var count: BigInteger? = null,
    var templates: List<String>? = null,
    var channels: List<String>? = null,
)
