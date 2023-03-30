package co.novu.dto.response

data class TopicResponse(
    var _id: String? = null,
    var _organizationId: String? = null,
    var _environmentId: String? = null,
    var key: String? = null,
    var name: String? = null,
    var subscribers: List<String>? = null
)
