package co.novu.dto.request

data class BulkTriggerEventRequest(
    val events: List<TriggerEventRequest>
)
