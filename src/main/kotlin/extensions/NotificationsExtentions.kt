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

/**
 * Retrieve all Notifications ever sent with the API key provided. This function supports pagination.
 * @param notificationRequest an instance of [NotificationRequest]
 * @return [PaginatedResponseWrapper] with a list of [Notification] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
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

/**
 * Retrieve the statistics of all Notifications ever sent with the API key provided.
 * @return [ResponseWrapper] with [NotificationStatsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.notificationsStats(): ResponseWrapper<NotificationStatsResponse>? {
    val response = notificationsApi.getNotificationsStats()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve the statistics of Notifications graph associated with the API key provided.
 * @return [ResponseWrapper] with a list of [NotificationGraphStatsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.notificationGraphStats(): ResponseWrapper<List<NotificationGraphStatsResponse>>? {
    val response = notificationsApi.getNotificationGraphStats()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Notification.
 * @param notificationId the ID of the Notification to be retrieved
 * @return [ResponseWrapper] with [Notification] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.notification(notificationId: String): ResponseWrapper<Notification>? {
    val response = notificationsApi.getNotification(notificationId)
    return response.extractResponse(logger, config.enableLogging)
}
