package co.novu.dto

import com.google.gson.annotations.SerializedName

open class Subscriber(
    @SerializedName("_id")
    var id: String? = null,
    var subscriberId: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var avatar: String? = null
)
