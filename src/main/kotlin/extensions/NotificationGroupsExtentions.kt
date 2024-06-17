package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.DeleteWorkflowGroupResponse
import co.novu.dto.response.NotificationGroupsResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.getWorkflowGroups(): ResponseWrapper<List<NotificationGroupsResponse>>? {
    val response = notificationGroupsApi.getNotificationGroups()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createWorkflowGroup(request: CreateByNameRequest): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.createNotificationGroup(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getWorkflowGroup(id: String): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.getWorkflowGroup(id)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWorkflowGroup(
    id: String,
    request: CreateByNameRequest,
): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.updateWorkflowGroup(id, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteWorkflowGroup(id: String): ResponseWrapper<DeleteWorkflowGroupResponse>? {
    val response = notificationGroupsApi.deleteWorkflowGroup(id)
    return response.extractResponse(logger, config.enableLogging)
}
