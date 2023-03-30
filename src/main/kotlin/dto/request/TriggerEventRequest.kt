package co.novu.dto.request

class TriggerEventRequest private constructor() : BaseEventRequest() {
    private var to: Any? = null

    companion object {
        private fun initFields(
            name: String,
            to: Any,
            payload: Map<String, Any>,
            overrides: Map<String, Any>?,
            transactionId: String?
        ) =
            TriggerEventRequest()
                .apply {
                    init(name, payload, overrides, transactionId)
                    this.to = to
                }

        @JvmName("fromString")
        operator fun invoke(
            name: String,
            to: String,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null
        ) = initFields(name, to, payload, overrides, transactionId)

        @JvmName("fromListOfString")
        operator fun invoke(
            name: String,
            to: List<String>,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null
        ) = initFields(name, to, payload, overrides, transactionId)

        @JvmName("fromListOfSubscribers")
        operator fun invoke(
            name: String,
            to: List<SubscriberRequest>,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null
        ) = initFields(name, to, payload, overrides, transactionId)

        @JvmName("fromSubscribers")
        operator fun invoke(
            name: String,
            to: SubscriberRequest,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null
        ) = initFields(name, to, payload, overrides, transactionId)
    }
}
