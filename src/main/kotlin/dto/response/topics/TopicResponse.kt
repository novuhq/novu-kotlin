package co.novu.dto.response.topics

import co.novu.dto.response.subscribers.SubscriberResponse

data class TopicResponse(
    var _id: String? = null,
    var _organizationId: String? = null,
    var _environmentId: String? = null,
    var key: String? = null,
    var name: String? = null,
    var subscriber: List<SubscriberResponse>? = null
)
