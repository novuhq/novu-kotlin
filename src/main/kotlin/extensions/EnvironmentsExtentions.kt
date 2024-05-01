package co.novu.extensions

import co.novu.Novu
import co.novu.dto.ApiKeys
import co.novu.dto.Widget
import co.novu.dto.request.CreateEnvironmentRequest
import co.novu.dto.request.UpdateEnvironmentRequest
import co.novu.dto.response.GetEnvironmentResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.currentEnvironment(): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.getCurrentEnvironment()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createEnvironment(request: CreateEnvironmentRequest): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.createEnvironment(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.environments(): ResponseWrapper<List<GetEnvironmentResponse>>? {
    val response = environmentsApi.getEnvironments()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateEnvironment(environmentId: String, request: UpdateEnvironmentRequest): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.updateEnvironment(environmentId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.apiKeys(): ResponseWrapper<List<ApiKeys>>? {
    val response = environmentsApi.getApiKeys()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.regenrateApiKey(): ResponseWrapper<List<ApiKeys>>? {
    val response = environmentsApi.regenerateApiKey()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWidgetSettings(request: Widget): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.updateWidgetSettings(request)
    return response.extractResponse(logger, config.enableLogging)
}
