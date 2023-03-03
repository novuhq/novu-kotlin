package co.novu.dto

open class Subscriber(
    var subscriberId: String,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var avatar: String? = null
)
