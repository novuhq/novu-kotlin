package dto.blueprints

data class Template(
    private var _id: String? = null,
    private var type: String? = null,
    private var active: Boolean? = null,
    private var subject: String? = null,
    private var content: List<Content>? = null,
    private var contentType: String? = null,
    private var _environmentId: String? = null,
    private var _organizationId: String? = null,
    private var _creatorId: String? = null,
    private var _parentId: String? = null,
    private var _layoutId: String? = null,
    private var variables: List<Variables>? = null,
    private var createdAt: String? = null,
    private var updatedAt: String? = null,
    private var __v: Long? = null
)
