package co.novu.dto.response

data class GetLayoutsResponse(
    val _id: String? = null,
    val _organizationId: String? = null,
    val _environmentId: String? = null,
    val _creatorId: String? = null,
    val name: String? = null,
    val description: String? = null,
    val channel: String? = null,
    val content: String? = null,
    val contentType: String? = null,
    val variables: List<Any>? = null,
    val isDefault: Boolean? = null,
    val isDeleted: Boolean? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val _parentId: String? = null
)
