package co.novu.dto.request.events

abstract class BaseEventRequest {

    // Mandatory fields
    private lateinit var name: String
    private var payload: Map<String, Any> = mapOf()


    //Optional fields
    private var overrides: Map<String, Any>? = null
    private var transactionId: String? = null

    protected fun init(
        _name: String,
        _payload: Map<String, Any>,
        _overrides: Map<String, Any>? = null,
        _transactionId: String? = null
    ): BaseEventRequest {

        return this.apply {
            this.name = _name
            this.payload = _payload
            this.overrides = _overrides
            this.transactionId = _transactionId
        }
    }

}