package co.novu.dto.response

data class GetLayoutsResponse(
    val _id: String,
    val _organizationId: String,
    val _environmentId: String,
    val _creatorId: String,
    val name: String,
    val description: String,
    val channel: String,
    val content: String,
    val contentType: String,
    val variables: List<Any>,
    val isDefault: Boolean,
    val isDeleted: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val _parentId: String
)
