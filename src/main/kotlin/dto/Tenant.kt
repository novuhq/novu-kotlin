package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Tenant(
    @SerializedName("_environmentId")
    private var environmentId: String? = null,
    @SerializedName("_id")
    private var id: String? = null,
    private var createdAt: String? = null,
    private var data: Any? = null,
    private var identifier: String? = null,
    private var name: String? = null,
    private var updatedAt: String? = null,
)
