package co.novu.dto.response.changes

data class ChangesResponse(
    var _id: String? = null,
    var _creatorId: String? = null,
    var _environmentId: String? = null,
    var _organizationId: String? = null,
    var _entityId: String? = null,
    var enabled: Boolean? = null,
    var type: String? = null,
    var change: Any? = null,
    var createdAt: String? = null,
    var _parentId: String? = null
)