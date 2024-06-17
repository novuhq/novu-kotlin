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

suspend fun Novu.getWorkflows(
    page: Int?,
    limit: Int?,
): PaginatedResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflows(page, limit)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createWorkflow(request: WorkflowRequest): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.createWorkflow(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWorkflow(
    workflowId: String,
    request: UpdateWorkflowRequest,
): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflow(workflowId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteWorkflow(workflowId: String): ResponseWrapper<Boolean>? {
    val response = workflowsApi.deleteWorkflow(workflowId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getWorkflow(workflowId: String): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflow(workflowId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWorkflowStatus(
    workflowId: String,
    request: UpdateWorkflowStatusRequest,
): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflowStatus(workflowId, request)
    return response.extractResponse(logger, config.enableLogging)
}
