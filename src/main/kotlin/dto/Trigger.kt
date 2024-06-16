package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Trigger(
    val type: String? = null,
    @SerializedName("_id")
    val id: String? = null,
    val identifier: String? = null,
    val variables: List<Variables>? = null,
    val subscriberVariables: List<Variables>? = null,
    val reservedVariables: List<Variables>? = null,
)
