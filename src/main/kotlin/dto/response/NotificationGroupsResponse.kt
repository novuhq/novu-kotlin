package co.novu.dto.response

data class NotificationGroupsResponse(
    var _id: String,
    var name: String,
    var _environmentId: String,
    var _organizationId: String,
    var _parentId: String,
)