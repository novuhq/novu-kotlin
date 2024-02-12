package co.novu.dto.request

import co.novu.dto.Topic

class TriggerEventRequest private constructor() : BaseEventRequest() {
    private var to: Any? = null

    companion object {
        private fun initFields(
            name: String,
            to: Any,
            payload: Map<String, Any>,
            overrides: Map<String, Any>?,
            transactionId: String?,
            actor: String? = null,
            tenant: String? = null
        ) =
            TriggerEventRequest()
                .apply {
                    init(name, payload, overrides, transactionId, actor, tenant)
                    this.to = to
                }

        @JvmName("fromString")
        operator fun invoke(
            name: String,
            to: String,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) = initFields(name, to, payload, overrides, transactionId, actor, tenant)

        @JvmName("fromListOfString")
        operator fun invoke(
            name: String,
            to: List<String>,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) = initFields(name, to, payload, overrides, transactionId, actor, tenant)

        @JvmName("fromListOfSubscribers")
        operator fun invoke(
            name: String,
            to: List<SubscriberRequest>,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) = initFields(name, to, payload, overrides, transactionId, actor, tenant)

        @JvmName("fromSubscriber")
        operator fun invoke(
            name: String,
            to: SubscriberRequest,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) = initFields(name, to, payload, overrides, transactionId, actor, tenant)

        @JvmName("fromListOfTopics")
        operator fun invoke(
            name: String,
            to: List<Topic>,
            payload: Map<String, Any> = mapOf(),
            overrides: Map<String, Any>? = null,
            transactionId: String? = null,
            actor: String? = null,
            tenant: String? = null
        ) = initFields(name, to, payload, overrides, transactionId, actor, tenant)
    }
}
