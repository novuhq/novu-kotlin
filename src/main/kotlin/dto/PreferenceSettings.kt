package co.novu.dto

data class PreferenceSettings(
    val email: String? = null,
    val sms: String? = null,
    val in_app: String? = null,
    val chat: String? = null,
    val push: String? = null
)
