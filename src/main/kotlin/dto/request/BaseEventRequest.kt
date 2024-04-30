package co.novu.dto.request

import co.novu.dto.Tenant

abstract class BaseEventRequest {

    // Mandatory fields
    private lateinit var name: String
    private var payload: Map<String, Any> = mapOf()

    // Optional fields
    private var overrides: Map<String, Any>? = null
    private var transactionId: String? = null

    /**
     * Possible types this field accepts are; String or [Map]
     *
     * For example:
     *
     * actor = mapOf(
     *         "subscriberId" to "sId",
     *         "email" to "email@mail.com",
     *         "firstName" to "fName",
     *         "lastName" to "lName",
     *         "phone" to "phoneNo")
     */
    private var actor: Any? = null

    /**
     * Possible types this field accepts are; String or [Tenant]
     *
     * For example:
     *
     * tenant = Tenant(
     *          identifier = "identifier",
     *          name = "name",
     *          data = Any())
     */
    private var tenant: Any? = null

    protected fun init(
        name: String,
        payload: Map<String, Any>,
        overrides: Map<String, Any>? = null,
        transactionId: String? = null,
        actor: Any? = null,
        tenant: Any? = null
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
