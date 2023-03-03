package co.novu.dto.response.topics

import co.novu.dto.response.subscribers.SubscriberResponse


data class TopicResponse(
    var _id: String,
    var _organizationId: String,
    var _environmentId: String,
    var key: String,
    var name: String,
    var subscriber: List<SubscriberResponse>
)