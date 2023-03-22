package co.novu.dto.request.subscribers

import co.novu.dto.Subscriber

class SubscriberRequest(
    subscriberId: String,
    firstName: String? = null,
    lastName: String? = null,
    email: String? = null,
    phone: String? = null,
    avatar: String? = null
) : Subscriber(
    subscriberId,
    firstName,
    lastName,
    email,
    phone,
    avatar
)
