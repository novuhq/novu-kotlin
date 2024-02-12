package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Template(
    @SerializedName("_id")
    var id: String? = null,
    var name: String? = null,
    var critical: Boolean? = null,
    var triggers: List<Trigger>? = null
)
