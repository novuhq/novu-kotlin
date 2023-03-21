package co.novu.extentions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.getNotificationTemplates() = runBlocking {
    notificationTemplatesApi.getNotificationTemplates()
        .body()
        .apply { logger.info { this } }
}

fun Novu.createNotificationTemplates(request: co.novu.dto.request.NotificationTemplates) = runBlocking {
    notificationTemplatesApi.createNotificationTemplates(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateNotificationTemplates(templateId: String, request: co.novu.dto.request.NotificationTemplates) = runBlocking {
    notificationTemplatesApi.updateNotificationTemplates(templateId, request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteNotificationTemplate(templateId: String) = runBlocking {
    notificationTemplatesApi.deleteNotificationTemplate(templateId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getNotificationTemplate(templateId: String) = runBlocking {
    notificationTemplatesApi.getNotificationTemplate(templateId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateNotificationTemplateStatus(templateId: String, request: co.novu.dto.request.UpdateNotificationStatusRequest) = runBlocking {
    notificationTemplatesApi.updateNotificationTemplateStatus(templateId, request)
        .body()
        .apply { logger.info { this } }
}