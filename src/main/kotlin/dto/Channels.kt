package dto

data class Channels(
    var email: Email? = null,
    var sms: Sms? = null,
    var chat: Chat? = null,
    var push: Push? = null
)
