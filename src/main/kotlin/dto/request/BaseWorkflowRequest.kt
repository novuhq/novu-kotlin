package dto.request

import co.novu.dto.PreferenceSettings
import co.novu.dto.Step

open class BaseWorkflowRequest {
    var description: String? = null
    var active: Boolean? = null
    var name: String? = null
    var blueprintId: String? = null
    var draft: Boolean? = null
    var data: Any? = null
    var preferenceSettings: PreferenceSettings? = null
    var critical: Boolean? = null
    var tags: List<String>? = null
    var steps: List<Step>? = null
    var notificationGroupId: String? = null
}
