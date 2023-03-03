package co.novu.dto

data class Channel(
    val credentials: String,
    val providerId: String? = null,
    val _integrationId: String? = null
)