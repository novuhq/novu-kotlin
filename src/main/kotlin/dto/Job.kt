package co.novu.dto

data class Job(
    var _id: String? = null,
    var digest: Any? = null,
    var status: String? = null,
    var payload: Any? = null,
    var step: Step? = null,
    var _notificationId: String? = null,
    var type: String? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var executionDetails: List<ExecutionDetails>? = null,
    var providerId: String? = null
)
