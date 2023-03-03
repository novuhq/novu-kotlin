package co.novu.api

import java.util.*


data class TestVariables(
    val APIKEY: String = "aeaf31aa1834b3a317dcf6970d028dae",
    val EXISTING_CHANNEL: String = "existing_channel",
    val NON_EXISTING_CHANNEL: String = "non_existing_channel",
    var TRANSACTION_ID: String = UUID.randomUUID().toString(),
    var SUBSCRIBER_ID: String = UUID.randomUUID().toString(),
    var TEMPLATE_ID: String = UUID.randomUUID().toString(),
    var MESSAGE_ID: String = UUID.randomUUID().toString(),
    var TYPE: String = "TEST"
)