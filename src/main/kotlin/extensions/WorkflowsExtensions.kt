package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.UpdateWorkflowRequest
import co.novu.dto.request.UpdateWorkflowStatusRequest
import co.novu.dto.request.WorkflowRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.WorkflowResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Workflows. This function supports pagination.
 * @param page the page number to be retrieved
 * @param limit the size of the page to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflows(
    page: Int?,
    limit: Int?,
): PaginatedResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflows(page, limit)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a Workflow.
 * @param request an instance of [WorkflowRequest]
 * @return [ResponseWrapper] with [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createWorkflow(request: WorkflowRequest): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.createWorkflow(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Workflow.
 * @param workflowId the ID of the Workflow to be updated
 * @param request an instance of [UpdateWorkflowRequest]
 * @return [ResponseWrapper] with [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateWorkflow(
    workflowId: String,
    request: UpdateWorkflowRequest,
): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflow(workflowId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Workflow.
 * @param workflowId the ID of the Workflow to be deleted
 * @return [ResponseWrapper] with [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteWorkflow(workflowId: String): ResponseWrapper<Boolean>? {
    val response = workflowsApi.deleteWorkflow(workflowId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Workflow.
 * @param workflowId the ID of the Workflow to be retrieved
 * @return [ResponseWrapper] with [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getWorkflow(workflowId: String): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflow(workflowId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Workflow status.
 * @param workflowId the ID of the Workflow to be updated
 * @param request an instance of [UpdateWorkflowStatusRequest]
 * @return [ResponseWrapper] with [WorkflowResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateWorkflowStatus(
    workflowId: String,
    request: UpdateWorkflowStatusRequest,
): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflowStatus(workflowId, request)
    return response.extractResponse(logger, config.enableLogging)
}
