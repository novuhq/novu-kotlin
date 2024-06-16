package co.novu.dto.blueprints

import co.novu.dto.NotificationGroup
import co.novu.dto.PreferenceSettings
import co.novu.dto.Trigger
import com.google.gson.annotations.SerializedName

data class Blueprint(
    @SerializedName("_id")
    private var id: String? = null,
    private var name: String? = null,
    private var description: String? = null,
    private var active: Boolean? = null,
    private var draft: Boolean? = null,
    private var critical: Boolean? = null,
    private var isBlueprint: Boolean? = null,
    @SerializedName("_notificationGroupId")
    private var notificationGroupId: String? = null,
    private var blueprintId: String? = null,
    private var tags: List<String>? = null,
    private var triggers: List<Trigger>? = null,
    private var steps: List<Step>? = null,
    private var preferenceSettings: PreferenceSettings? = null,
    @SerializedName("_environmentId")
    private var environmentId: String? = null,
    @SerializedName("_organizationId")
    private var organizationId: String? = null,
    @SerializedName("_creatorId")
    private var creatorId: String? = null,
    @SerializedName("_parentId")
    private var parentId: String? = null,
    private var deleted: Boolean? = null,
    private var createdAt: String? = null,
    private var updatedAt: String? = null,
    @SerializedName("__v")
    private var version: Long? = null,
    private var notificationGroup: NotificationGroup? = null,
)
