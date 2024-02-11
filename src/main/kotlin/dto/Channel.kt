package co.novu.dto

import com.google.gson.annotations.SerializedName

data class Channel(
    val credentials: ChannelCredentials? = null,
    val providerId: String? = null,
    @SerializedName("_integrationId")
    val integrationId: String? = null
)
