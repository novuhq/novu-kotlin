package co.novu.dto

import com.google.gson.annotations.SerializedName

data class PreferenceSettings(
    val email: Boolean? = null,
    val sms: Boolean? = null,
    @SerializedName("in_app")
    val inApp: Boolean? = null,
    val chat: Boolean? = null,
    val push: Boolean? = null
)
