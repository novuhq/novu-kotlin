package co.novu.dto

data class Channel(
    val credentials: ChannelCredentials,
    val providerId: String? = null,
    val _integrationId: String? = null
)