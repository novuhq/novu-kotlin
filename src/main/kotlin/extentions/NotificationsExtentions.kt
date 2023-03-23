package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.getNotifications(channels: List<String>, templates: List<String>, emails: List<String>, search: String, page: String? = null, transactionId: String? = null) = runBlocking {
    val response = notificationsApi.getNotifications(channels, templates, emails, search, page, transactionId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getNotificationsStats() = runBlocking {
    val response = notificationsApi.getNotificationsStats()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getNotificationGraphStats() = runBlocking {
    val response = notificationsApi.getNotificationGraphStats()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getNotification(notificationId: String) = runBlocking {
    val response = notificationsApi.getNotification(notificationId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
