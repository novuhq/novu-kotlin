package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.integrations.IntegrationRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.getIntegrations() = runBlocking {
    integrationsApi.getIntegrations()
        .body()
        .apply { logger.info { this } }
}

fun Novu.createIntegration(request: IntegrationRequest) = runBlocking {
    integrationsApi.createIntegration(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getActiveIntegrations() = runBlocking {
    integrationsApi.getActiveIntegrations()
        .body()
        .apply { logger.info { this } }
}

fun Novu.getProviderWebhook(providerId: String) = runBlocking {
    integrationsApi.getProviderWebhook(providerId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateIntegration(integrationId: String, request: IntegrationRequest) = runBlocking {
    integrationsApi.updateIntegration(integrationId, request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteIntegration(integrationId: String) = runBlocking {
    integrationsApi.deleteIntegration(integrationId)
        .body()
        .apply { logger.info { this } }
}
