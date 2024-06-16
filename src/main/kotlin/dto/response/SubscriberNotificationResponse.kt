package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class SubscriberNotificationResponse(
    @SerializedName("_id")
    var id: String? = null,
    @SerializedName("_templateId")
    var templateId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_messageTemplateId")
    var messageTemplateId: String? = null,
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_notificationId")
    var notificationId: String? = null,
    @SerializedName("_subscriberId")
    var subscriberId: String? = null,
    var subscriber: Any? = null,
    var template: Any? = null,
    var templateIdentifier: String? = null,
    var createdAt: String? = null,
    var content: String? = null,
    var transactionId: String? = null,
    var channel: String? = null,
    var seen: Boolean? = null,
    var email: String? = null,
    var phone: String? = null,
    var directWebhookUrl: String? = null,
    var providerId: String? = null,
    var deviceTokens: List<String>? = null,
    var title: String? = null,
    var lastSeenDate: String? = null,
    var cta: Any? = null,
    @SerializedName("_feedId")
    var feedId: String? = null,
    var status: String? = null,
    var errorId: String? = null,
    var errorText: String? = null,
    var payload: Any? = null,
    var overrides: Any? = null,
    var subject: Any? = null,
)
