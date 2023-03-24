package co.novu.dto.response

import co.novu.dto.NotificationGroup
import co.novu.dto.PreferenceSettings
import co.novu.dto.Step
import co.novu.dto.Trigger

data class NotificationTemplates(
    val _id: String? = null,
    val description: String? = null,
    val active: Boolean? = null,
    val name: String? = null,
    val draft: Boolean? = null,
    val preferenceSettings: PreferenceSettings? = null,
    val critical: Boolean? = null,
    val tags: List<String>? = null,
    val steps: List<Step>? = null,
    val _organizationId: String? = null,
    val _creatorId: String? = null,
    val _environmentId: String? = null,
    val triggers: List<Trigger>? = null,
    val _notificationGroupId: String? = null,
    val deleted: Boolean? = null,
    val deletedAt: String? = null,
    val deletedBy: String? = null,
    val notificationGroup: NotificationGroup? = null,
    val isBlueprint: Boolean? = null
)
