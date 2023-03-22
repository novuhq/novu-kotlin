package co.novu.dto.response.subscribers

import co.novu.dto.Preference
import co.novu.dto.Template

data class SubscriberPreferenceResponse(
    val template: Template? = null,
    val preference: Preference? = null
)
