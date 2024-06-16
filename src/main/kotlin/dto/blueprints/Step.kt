package co.novu.dto.blueprints

import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("_templateId")
    val templateId: String? = null,
    val uuid: String? = null,
    val name: String? = null,
    val active: Boolean? = null,
    val shouldStopOnFail: Boolean? = null,
    val template: Any? = null,
    val filters: Any? = null,
    @SerializedName("_parentId")
    val parentId: String? = null,
    val metadata: Any? = null,
    val replyCallback: Any? = null,
)
