package co.novu.extensions

import co.novu.Novu
import co.novu.dto.Notification
import co.novu.dto.request.NotificationRequest
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.notifications(notificationRequest: NotificationRequest): PaginatedResponseWrapper<Notification>? {
    val response =
        notificationsApi.getNotifications(
            channels = notificationRequest.channels,
            templates = notificationRequest.templates,
            emails = notificationRequest.emails,
            search = notificationRequest.search,
            page = notificationRequest.page,
            transactionId = notificationRequest.transactionId,
        )
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.notificationsStats(): ResponseWrapper<NotificationStatsResponse>? {
    val response = notificationsApi.getNotificationsStats()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.notificationGraphStats(): ResponseWrapper<List<NotificationGraphStatsResponse>>? {
    val response = notificationsApi.getNotificationGraphStats()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.notification(notificationId: String): ResponseWrapper<Notification>? {
    val response = notificationsApi.getNotification(notificationId)
    return response.extractResponse(logger, config.enableLogging)
}
