package co.novu.dto.response

data class CheckTopicSubscriberResponse(
    var _organizationId: String? = null,
    var _environmentId: String? = null,
    var _subscriberId: String? = null,
    var _topicId: String? = null,
    var topicKey: String? = null,
    var externalSubscriberId: String? = null
)