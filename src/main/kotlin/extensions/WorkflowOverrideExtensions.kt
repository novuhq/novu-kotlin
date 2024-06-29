package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.GetWorkflowOverrideRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import dto.request.CreateWorkflowOverrideRequest
import dto.workflowoverrides.UpdateWorkflowOverrideRequest
import dto.workflowoverrides.WorkflowOverride
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Create a Workflow override.
 * @param request an instance of [CreateWorkflowOverrideRequest]
 * @return [ResponseWrapper] with [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createWorkflowOverride(request: CreateWorkflowOverrideRequest): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.createWorkflowOverride(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of Workflow override. This function supports pagination.
 * @param request an instance of [GetWorkflowOverrideRequest]
 * @return [PaginatedResponseWrapper] with a list of [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflowOverrides(request: GetWorkflowOverrideRequest): PaginatedResponseWrapper<WorkflowOverride>? {
    val params: MutableMap<String, Any> = HashMap()
    request.page?.let { params["page"] = it }
    request.limit?.let { params["limit"] = it }
    val response = workflowOverrideApi.getWorkflowOverrides(params)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Workflow override associated with a Tenant.
 * @param workflowId the ID of the Workflow override to be retrieved
 * @param tenantId the ID of the Tenant
 * @return [ResponseWrapper] with [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflowOverride(
    workflowId: String,
    tenantId: String,
): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.getWorkflowOverride(workflowId, tenantId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Workflow override.
 * @param overrideId the ID of the Workflow override to be retrieved
 * @return [ResponseWrapper] with [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflowOverrideById(overrideId: String): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.getWorkflowOverrideById(overrideId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Workflow override.
 * @param overrideId the ID of the Workflow override to be updated
 * @param request an instance of [UpdateWorkflowOverrideRequest]
 * @return [ResponseWrapper] with [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateWorkflowOverrideById(
    overrideId: String,
    request: UpdateWorkflowOverrideRequest,
): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.updateWorkflowOverrideById(overrideId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Workflow override associated with a Tenant.
 * @param workflowId the ID of the Workflow override to be updated
 * @param tenantId the ID of the Tenant
 * @param request an instance of [UpdateWorkflowOverrideRequest]
 * @return [ResponseWrapper] with [WorkflowOverride] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateWorkflowOverride(
    workflowId: String,
    tenantId: String,
    request: UpdateWorkflowOverrideRequest,
): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.updateWorkflowOverride(workflowId, tenantId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Workflow override.
 * @param overrideId the ID of the Workflow override to be deleted
 * @return [ResponseWrapper] with [Boolean] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteWorkflowOverride(overrideId: String): ResponseWrapper<Boolean>? {
    val response = workflowOverrideApi.deleteWorkflowOverride(overrideId)
    return response.extractResponse(logger, config.enableLogging)
}
