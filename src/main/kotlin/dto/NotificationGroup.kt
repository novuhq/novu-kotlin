package co.novu.dto

data class NotificationGroup(
    val _id: String,
    val name: String,
    val _organizationId: String,
    val _environmentId: String,
    val _parentId: String
)
