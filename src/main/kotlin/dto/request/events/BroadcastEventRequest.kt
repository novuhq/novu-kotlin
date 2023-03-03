package co.novu.dto.request.events

class BroadcastEventRequest private constructor() : BaseEventRequest() {


    companion object {
        operator fun invoke(
            name: String,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null
        ) =
            BroadcastEventRequest().apply { init(name, payload, overrides, transactionId) }

    }
}



