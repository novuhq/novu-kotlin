package co.novu.dto.response.subscribers

import co.novu.dto.Channel
import co.novu.dto.Subscriber
import java.math.BigInteger

class SubscriberResponse(
    subscriberId: String? = null,
    firstName: String? = null,
    lastName: String? = null,
    email: String? = null,
    phone: String? = null,
    avatar: String? = null,
    var _id: String? = null,
    var _organizationId: String? = null,
    var _environmentId: String? = null,
    var deleted: Boolean? = null,
    var createdAt: String? = null,
    var updatedAt: String? = null,
    var channels: List<Channel>? = null,
    var locale: Any? = null,
    var __v: BigInteger? = null,
    var isOnline: Boolean? = null,
    var lastOnlineAt: String? = null
) : Subscriber(
    subscriberId,
    firstName,
    lastName,
    email,
    phone,
    avatar
)
