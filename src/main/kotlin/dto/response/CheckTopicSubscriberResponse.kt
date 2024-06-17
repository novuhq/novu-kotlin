package co.novu.dto.response

import com.google.gson.annotations.SerializedName

data class CheckTopicSubscriberResponse(
    @SerializedName("_organizationId")
    var organizationId: String? = null,
    @SerializedName("_environmentId")
    var environmentId: String? = null,
    @SerializedName("_subscriberId")
    var subscriberId: String? = null,
    @SerializedName("_topicId")
    var topicId: String? = null,
    var topicKey: String? = null,
    var externalSubscriberId: String? = null,
)
