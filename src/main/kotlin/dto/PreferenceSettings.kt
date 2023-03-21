package co.novu.dto

data class PreferenceSettings(
    val email: String,
    val sms: String,
    val in_app: String,
    val chat: String,
    val push: String
)
