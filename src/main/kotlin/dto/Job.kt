package co.novu.dto

data class Job(
    var _id: String? = null,
    var type: String? = null,
    var digest: Any? = null,
    var executionDetails: List<ExecutionDetails>? = null,
    var step: Step? = null,
    var payload: Any? = null,
    var status: String? = null,
    var providerId: Any? = null
)
