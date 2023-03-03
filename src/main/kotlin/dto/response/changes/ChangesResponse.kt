package co.novu.dto.response.changes

data class ChangesResponse(
    var _id: String?,
    var _creatorId: String?,
    var _environmentId: String?,
    var _organizationId: String?,
    var _entityId: String?,
    var enabled: Boolean?,
    var type: String,
    var change: Any,
    var createdAt: String,
    var _parentId: String
)