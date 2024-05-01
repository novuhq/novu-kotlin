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

suspend fun Novu.createWorkflowOverride(request: CreateWorkflowOverrideRequest): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.createWorkflowOverride(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getWorkflowOverrides(request: GetWorkflowOverrideRequest): PaginatedResponseWrapper<WorkflowOverride>? {
    val params: MutableMap<String, Any> = HashMap()
    request.page?.let { params["page"] = it }
    request.limit?.let { params["limit"] = it }
    val response = workflowOverrideApi.getWorkflowOverrides(params)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getWorkflowOverride(workflowId: String, tenantId: String): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.getWorkflowOverride(workflowId, tenantId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getWorkflowOverrideById(overrideId: String): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.getWorkflowOverrideById(overrideId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWorkflowOverrideById(overrideId: String, request: UpdateWorkflowOverrideRequest): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.updateWorkflowOverrideById(overrideId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWorkflowOverride(workflowId: String, tenantId: String, request: UpdateWorkflowOverrideRequest): ResponseWrapper<WorkflowOverride>? {
    val response = workflowOverrideApi.updateWorkflowOverride(workflowId, tenantId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteWorkflowOverride(overrideId: String): ResponseWrapper<Boolean>? {
    val response = workflowOverrideApi.deleteWorkflowOverride(overrideId)
    return response.extractResponse(logger, config.enableLogging)
}
