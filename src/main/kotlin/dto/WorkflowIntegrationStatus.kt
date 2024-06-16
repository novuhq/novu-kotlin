package dto

data class WorkflowIntegrationStatus(
    var hasActiveIntegrations: Boolean? = null,
    var channels: Channels? = null,
)
