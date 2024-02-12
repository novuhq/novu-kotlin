package co.novu.dto.response

import co.novu.dto.NotificationGroup
import co.novu.dto.PreferenceSettings
import co.novu.dto.Step
import co.novu.dto.Trigger
import com.google.gson.annotations.SerializedName
import dto.WorkflowIntegrationStatus

data class WorkflowResponse(
    @SerializedName("_id")
    val id: String? = null,
    val description: String? = null,
    val active: Boolean? = null,
    val name: String? = null,
    val draft: Boolean? = null,
    val preferenceSettings: PreferenceSettings? = null,
    val critical: Boolean? = null,
    val tags: List<String>? = null,
    val steps: List<Step>? = null,
    @SerializedName("_organizationId")
    val organizationId: String? = null,
    @SerializedName("_creatorId")
    val creatorId: String? = null,
    @SerializedName("_environmentId")
    val environmentId: String? = null,
    val triggers: List<Trigger>? = null,
    val notificationGroupId: String? = null,
    val deleted: Boolean? = null,
    val deletedAt: String? = null,
    val deletedBy: String? = null,
    val notificationGroup: NotificationGroup? = null,
    val isBlueprint: Boolean? = null,
    val workflowIntegrationStatus: WorkflowIntegrationStatus? = null
)
