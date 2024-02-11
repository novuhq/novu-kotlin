package dto.workflowoverrides

import co.novu.dto.PreferenceSettings

data class UpdateWorkflowOverrideRequest(
    var active: Boolean? = null,
    var preferenceSettings: PreferenceSettings? = null
)
