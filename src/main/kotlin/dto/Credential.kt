package co.novu.dto

data class Credential(
    var apiKey: String,
    var user: String,
    var secretKey: String,
    var domain: String,
    var password: String,
    var host: String,
    var port: String,
    var secure: Boolean,
    var region: String,
    var accountSid: String,
    var messageProfileId: String,
    var token: String,
    var from: String,
    var senderName: String,
    var projectName: String,
    var applicationId: String,
    var clientId: String
)
