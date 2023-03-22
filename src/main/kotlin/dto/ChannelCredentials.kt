package co.novu.dto

data class ChannelCredentials(
    var webhookUrl: String,
    var deviceTokens: List<String>
)
