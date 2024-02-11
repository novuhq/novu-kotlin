package co.novu.dto.request

class BroadcastEventRequest private constructor() : BaseEventRequest() {

    companion object {
        operator fun invoke(
            name: String,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) =
            BroadcastEventRequest().apply { init(name, payload, overrides, transactionId, actor, tenant) }
    }
}
