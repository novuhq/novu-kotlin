package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.IntegrationRequest
import co.novu.dto.response.IntegrationResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.integrations(): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.getIntegrations()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createIntegration(request: IntegrationRequest): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.createIntegration(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.activeIntegrations(): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.getActiveIntegrations()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.providerWebhook(providerId: String): ResponseWrapper<Boolean>? {
    val response = integrationsApi.getProviderWebhook(providerId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateIntegration(
    integrationId: String,
    request: IntegrationRequest,
): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.updateIntegration(integrationId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteIntegration(integrationId: String): ResponseWrapper<List<IntegrationResponse>>? {
    val response = integrationsApi.deleteIntegration(integrationId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.setIntegrationAsPrimary(integrationId: String): ResponseWrapper<IntegrationResponse>? {
    val response = integrationsApi.setPrimaryIntegration(integrationId)
    return response.extractResponse(logger, config.enableLogging)
}
