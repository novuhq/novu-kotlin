package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.IntegrationRequest
import co.novu.dto.response.IntegrationResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Integrations associated with the API key provided.
 * @return [ResponseWrapper] with a list of [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.integrations(): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.getIntegrations()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create an Integration.
 * @param request an instance of [IntegrationRequest]
 * @return [ResponseWrapper] with [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createIntegration(request: IntegrationRequest): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.createIntegration(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of active Integrations associated with the API key provided.
 * @return [ResponseWrapper] with a list of [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.activeIntegrations(): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.getActiveIntegrations()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve the status of a Provider's Webhook.
 * @param providerId the ID of the Provider whose status is to be retrieved
 * @return [ResponseWrapper] with a list of [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.providerWebhook(providerId: String): ResponseWrapper<Boolean>? {
    val response = integrationsApi.getProviderWebhook(providerId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update an Integration.
 * @param integrationId the ID of the Integration to be updated
 * @param request an instance of [IntegrationRequest]
 * @return [ResponseWrapper] with [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateIntegration(
    integrationId: String,
    request: IntegrationRequest,
): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.updateIntegration(integrationId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete an Integration.
 * @param integrationId the ID of the Integration to be deleted
 * @return [ResponseWrapper] with a list of [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteIntegration(integrationId: String): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.deleteIntegration(integrationId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Set a particular Integration as the primary Integration.
 * @param integrationId the ID of the Integration to be set as primary
 * @return [ResponseWrapper] with a list of [IntegrationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.setIntegrationAsPrimary(integrationId: String): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.setPrimaryIntegration(integrationId)
    return response.extractResponse(logger, config.enableLogging)
}
