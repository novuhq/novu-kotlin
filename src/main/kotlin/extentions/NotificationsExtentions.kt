package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.NotificationRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

@Deprecated("Use notifications(notificationRequest: NotificationRequest)")
fun Novu.notifications(channels: List<String>? = null, templates: List<String>? = null, emails: List<String>? = null, search: String? = null, page: String? = null, transactionId: String? = null) = runBlocking {
    val response = notificationsApi.getNotifications(channels, templates, emails, search, page?.let { BigInteger(it) }, transactionId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.notifications(notificationRequest: NotificationRequest) = runBlocking {
    val response = notificationsApi.getNotifications(
        channels = notificationRequest.channels,
        templates = notificationRequest.templates,
        emails = notificationRequest.emails,
        search = notificationRequest.search,
        page = notificationRequest.page,
        transactionId = notificationRequest.transactionId
    )
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
