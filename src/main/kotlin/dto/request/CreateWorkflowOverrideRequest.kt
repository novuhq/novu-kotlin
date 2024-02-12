package dto.request

import co.novu.dto.PreferenceSettings

data class CreateWorkflowOverrideRequest(
    var workflowId: String,
    var tenantId: String,
    var active: Boolean? = null,
    var preferenceSettings: PreferenceSettings? = null
)
