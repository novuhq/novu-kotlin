package co.novu.extentions

import co.novu.Novu
import co.novu.dto.response.NotificationTemplates
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getNotificationTemplates(page:BigInteger, limit:BigInteger) = runBlocking {
    notificationTemplatesApi.getNotificationTemplates(page, limit)
        .body()
        .apply { logger.info { this } }
}

fun Novu.createNotificationTemplates(request: NotificationTemplates) = runBlocking {
    notificationTemplatesApi.createNotificationTemplates(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateNotificationTemplates(templateId: String, request: NotificationTemplates) = runBlocking {
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