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

/**
 * Retrieve the data of the current Environment.
 * @return [ResponseWrapper] with [GetEnvironmentResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.currentEnvironment(): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.getCurrentEnvironment()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create an Environment.
 * @param request an instance of [CreateEnvironmentRequest]
 * @return [ResponseWrapper] with [GetEnvironmentResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createEnvironment(request: CreateEnvironmentRequest): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.createEnvironment(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of Environments.
 * @return [ResponseWrapper] with a list of [GetEnvironmentResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.environments(): ResponseWrapper<List<GetEnvironmentResponse>>? {
    val response = environmentsApi.getEnvironments()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update an Environment.
 * @param environmentId the ID of the Environment to be updated
 * @param request an instance of [UpdateEnvironmentRequest]
 * @return [ResponseWrapper] with [GetEnvironmentResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateEnvironment(
    environmentId: String,
    request: UpdateEnvironmentRequest,
): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.updateEnvironment(environmentId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of API Keys.
 * @return [ResponseWrapper] with a list of [ApiKeys] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.apiKeys(): ResponseWrapper<List<ApiKeys>>? {
    val response = environmentsApi.getApiKeys()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Regenerate API Keys.
 * @return [ResponseWrapper] with a list of [ApiKeys] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.regenrateApiKey(): ResponseWrapper<List<ApiKeys>>? {
    val response = environmentsApi.regenerateApiKey()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateWidgetSettings(request: Widget): ResponseWrapper<GetEnvironmentResponse>? {
    val response = environmentsApi.updateWidgetSettings(request)
    return response.extractResponse(logger, config.enableLogging)
}
