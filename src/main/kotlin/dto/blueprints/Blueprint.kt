package co.novu.dto.blueprints

import co.novu.dto.NotificationGroup
import co.novu.dto.PreferenceSettings
import co.novu.dto.Trigger

data class Blueprint(
    private var _id: String? = null,
    private var name: String? = null,
    private var description: String? = null,
    private var active: Boolean? = null,
    private var draft: Boolean? = null,
    private var critical: Boolean? = null,
    private var isBlueprint: Boolean? = null,
    private var _notificationGroupId: String? = null,
    private var blueprintId: String? = null,
    private var tags: List<String>? = null,
    private var triggers: List<Trigger>? = null,
    private var steps: List<Step>? = null,
    private var preferenceSettings: PreferenceSettings? = null,
    private var _environmentId: String? = null,
    private var _organizationId: String? = null,
    private var _creatorId: String? = null,
    private var _parentId: String? = null,
    private var deleted: Boolean? = null,
    private var createdAt: String? = null,
    private var updatedAt: String? = null,
    private var __v: Long? = null,
    private var notificationGroup: NotificationGroup? = null
)
