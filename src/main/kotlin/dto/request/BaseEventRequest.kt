package co.novu.dto.request

abstract class BaseEventRequest {

    // Mandatory fields
    private lateinit var name: String
    private var payload: Map<String, Any> = mapOf()

    // Optional fields
    private var overrides: Map<String, Any>? = null
    private var transactionId: String? = null
    private var actor: String? = null
    private var tenant: String? = null

    protected fun init(
        name: String,
        payload: Map<String, Any>,
        overrides: Map<String, Any>? = null,
        transactionId: String? = null,
        actor: String? = null,
        tenant: String? = null
    ): BaseEventRequest {
        return this.apply {
            this.name = name
            this.payload = payload
            this.overrides = overrides
            this.transactionId = transactionId
            this.actor = actor
            this.tenant = tenant
        }
    }
}
