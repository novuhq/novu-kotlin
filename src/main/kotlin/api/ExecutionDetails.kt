package co.novu.api

data class ExecutionDetails(
    val _id: String,
    val _jobId: String,
    val status: String,
    val detail: String,
    val isRetry: Boolean,
    val isTest: Boolean,
    val providerId: Any,
    val raw: String,
    val source: String
)
