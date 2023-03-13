package co.novu.dto.request.subscribers

data class UpdateSubscriberRequest(
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var phone: String? = null,
    var avatar: String? = null,
    var locale: String? = null,
    var data: Any? = null
)