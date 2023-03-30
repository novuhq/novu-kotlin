package co.novu.dto.request

import co.novu.dto.ChannelCredentials

data class UpdateSubscriberCredentialsRequest(
    var providerId: String,
    var credentials: ChannelCredentials
)
