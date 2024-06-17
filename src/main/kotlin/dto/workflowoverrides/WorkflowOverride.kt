package dto.workflowoverrides

import co.novu.dto.PreferenceSettings
import com.google.gson.annotations.SerializedName

data class WorkflowOverride(
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_workflowId")
    var workflowId: String? = null,
    @SerializedName("_tenantId")
    var tenantId: String? = null,
    var active: Boolean? = null,
    var preferenceSettings: PreferenceSettings? = null,
    var deleted: Boolean? = null,
    var deletedAt: String? = null,
    var deletedBy: String? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
)
