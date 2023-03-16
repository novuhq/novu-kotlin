package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.getNotifications(channels: List<String>, templates: List<String>, emails: List<String>, search: String, page: String? = null, transactionId: String? = null) = runBlocking {
    notificationsApi.getNotifications(channels, templates, emails, search, page, transactionId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getNotificationsStats() = runBlocking {
    notificationsApi.getNotificationsStats()
        .body()
        .apply { logger.info { this } }
}

fun Novu.getNotificationGraphStats() = runBlocking {
    notificationsApi.getNotificationGraphStats()
        .body()
        .apply { logger.info { this } }
}

fun Novu.getNotification(notificationId: String) = runBlocking {
    notificationsApi.getNotification(notificationId)
        .body()
        .apply { logger.info { this } }
}
