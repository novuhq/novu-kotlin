package co.novu.dto.response

import co.novu.dto.Job
import co.novu.dto.Subscriber
import co.novu.dto.Template

data class Message(
    val _id: String? = null,
    val _environmentId: String? = null,
    val _organizationId: String? = null,
    val transactionId: String? = null,
    val createdAt: String? = null,
    val channels: String? = null,
    val subscriber: Subscriber? = null,
    val template: Template? = null,
    val jobs: List<Job>? = null
)
