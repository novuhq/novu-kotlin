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

suspend fun Novu.getWorkflows(page: Int?, limit: Int?): PaginatedResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflows(page, limit)
    return response.extractResponse(logger)
}

suspend fun Novu.createWorkflow(request: WorkflowRequest): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.createWorkflow(request)
    return response.extractResponse(logger)
}

suspend fun Novu.updateWorkflow(templateId: String, request: UpdateWorkflowRequest): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflow(templateId, request)
    return response.extractResponse(logger)
}

suspend fun Novu.deleteWorkflow(templateId: String): ResponseWrapper<Boolean>? {
    val response = workflowsApi.deleteWorkflow(templateId)
    return response.extractResponse(logger)
}

suspend fun Novu.getWorkflow(templateId: String): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.getWorkflow(templateId)
    return response.extractResponse(logger)
}

suspend fun Novu.updateWorkflowStatus(templateId: String, request: UpdateWorkflowStatusRequest): ResponseWrapper<WorkflowResponse>? {
    val response = workflowsApi.updateWorkflowStatus(templateId, request)
    return response.extractResponse(logger)
}
