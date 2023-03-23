package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.integrations.IntegrationRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.getIntegrations() = runBlocking {
    val response = integrationsApi.getIntegrations()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.createIntegration(request: IntegrationRequest) = runBlocking {
    val response = integrationsApi.createIntegration(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getActiveIntegrations() = runBlocking {
    val response = integrationsApi.getActiveIntegrations()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.getProviderWebhook(providerId: String) = runBlocking {
    val response = integrationsApi.getProviderWebhook(providerId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateIntegration(integrationId: String, request: IntegrationRequest) = runBlocking {
    val response = integrationsApi.updateIntegration(integrationId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.deleteIntegration(integrationId: String) = runBlocking {
    val response = integrationsApi.deleteIntegration(integrationId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
