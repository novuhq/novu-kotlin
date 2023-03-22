package co.novu.dto

data class ChannelCredentials(
    var webhookUrl: String? = null,
    var deviceTokens: List<String>? = null
)
