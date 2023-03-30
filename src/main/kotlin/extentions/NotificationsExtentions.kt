package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.notifications(channels: List<String>? = null, templates: List<String>? = null, emails: List<String>? = null, search: String? = null, page: String? = null, transactionId: String? = null) = runBlocking {
    val response = notificationsApi.getNotifications(channels, templates, emails, search, page, transactionId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.notificationsStats() = runBlocking {
    val response = notificationsApi.getNotificationsStats()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.notificationGraphStats() = runBlocking {
    val response = notificationsApi.getNotificationGraphStats()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.notification(notificationId: String) = runBlocking {
    val response = notificationsApi.getNotification(notificationId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
