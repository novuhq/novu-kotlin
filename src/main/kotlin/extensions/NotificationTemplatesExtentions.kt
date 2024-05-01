package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.UpdateNotificationTemplateStatusRequest
import co.novu.dto.response.NotificationTemplates
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

@Deprecated("Use getWorkflows(): this will be removed in a future release")
suspend fun Novu.notificationTemplates(page: BigInteger, limit: BigInteger): PaginatedResponseWrapper<NotificationTemplates>? {
    val response = notificationTemplatesApi.getNotificationTemplates(page, limit)
    return response.extractResponse(logger, config.enableLogging)
}

@Deprecated("Use createWorkflow(): this will be removed in a future release")
suspend fun Novu.createNotificationTemplates(request: NotificationTemplates): ResponseWrapper<NotificationTemplates>? {
    val response = notificationTemplatesApi.createNotificationTemplates(request)
    return response.extractResponse(logger, config.enableLogging)
}

@Deprecated("Use updateWorkflow(): this will be removed in a future release")
suspend fun Novu.updateNotificationTemplates(templateId: String, request: NotificationTemplates): ResponseWrapper<NotificationTemplates>? {
    val response = notificationTemplatesApi.updateNotificationTemplates(templateId, request)
    return response.extractResponse(logger, config.enableLogging)
}

@Deprecated("Use deleteWorkflow(): this will be removed in a future release")
suspend fun Novu.deleteNotificationTemplate(templateId: String): ResponseWrapper<Boolean>? {
    val response = notificationTemplatesApi.deleteNotificationTemplate(templateId)
    return response.extractResponse(logger, config.enableLogging)
}

@Deprecated("Use getWorkflow(): this will be removed in a future release")
suspend fun Novu.notificationTemplate(templateId: String): ResponseWrapper<NotificationTemplates>? {
    val response = notificationTemplatesApi.getNotificationTemplate(templateId)
    return response.extractResponse(logger, config.enableLogging)
}

@Deprecated("Use updateWorkflowStatus(): this will be removed in a future release")
suspend fun Novu.updateNotificationTemplateStatus(templateId: String, request: UpdateNotificationTemplateStatusRequest): ResponseWrapper<NotificationTemplates>? {
    val response = notificationTemplatesApi.updateNotificationTemplateStatus(templateId, request)
    return response.extractResponse(logger, config.enableLogging)
}
