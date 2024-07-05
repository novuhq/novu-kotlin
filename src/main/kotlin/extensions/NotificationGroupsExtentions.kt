package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.DeleteWorkflowGroupResponse
import co.novu.dto.response.NotificationGroupsResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of NotificationGroups.
 * @return [ResponseWrapper] with a list of [NotificationGroupsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflowGroups(): ResponseWrapper<List<NotificationGroupsResponse>>? {
    val response = notificationGroupsApi.getNotificationGroups()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a NotificationGroup.
 * @param request an instance of [CreateByNameRequest]
 * @return [ResponseWrapper] with [NotificationGroupsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createWorkflowGroup(request: CreateByNameRequest): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.createNotificationGroup(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a NotificationGroup.
 * @param id the ID of the NotificationGroup to be retrieved
 * @return [ResponseWrapper] with [NotificationGroupsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflowGroup(id: String): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.getWorkflowGroup(id)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a NotificationGroup.
 * @param id the ID of the NotificationGroup to be updated
 * @param request an instance of [CreateByNameRequest]
 * @return [ResponseWrapper] with [NotificationGroupsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateWorkflowGroup(
    id: String,
    request: CreateByNameRequest,
): ResponseWrapper<NotificationGroupsResponse>? {
    val response = notificationGroupsApi.updateWorkflowGroup(id, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a NotificationGroup.
 * @param id the ID of the NotificationGroup to be deleted
 * @return [ResponseWrapper] with [DeleteWorkflowGroupResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteWorkflowGroup(id: String): ResponseWrapper<DeleteWorkflowGroupResponse>? {
    val response = notificationGroupsApi.deleteWorkflowGroup(id)
    return response.extractResponse(logger, config.enableLogging)
}
