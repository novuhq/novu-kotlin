package co.novu.extentions

import co.novu.Novu
import co.novu.dto.Widget
import co.novu.dto.request.CreateEnvironmentRequest
import co.novu.dto.request.UpdateEnvironmentRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.getEnvironments() = runBlocking {
    environmentsApi.getEnvironments()
        .body()
        .apply { logger.info { this } }
}

fun Novu.createEnvironment(request: CreateEnvironmentRequest) = runBlocking {
    environmentsApi.createEnvironment(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getEnvironment(environmentId: String) = runBlocking {
    environmentsApi.getEnvironment(environmentId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateEnvironment(environmentId: String, request: UpdateEnvironmentRequest) = runBlocking {
    environmentsApi.updateEnvironment(environmentId, request)
        .apply { logger.info { this } }
}

fun Novu.getApiKeys() = runBlocking {
    environmentsApi.getApiKeys()
        .body()
        .apply { logger.info { this } }
}

fun Novu.regenrateApiKey() = runBlocking {
    environmentsApi.regenerateApiKey()
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateWidgetSettings(request: Widget) = runBlocking {
    environmentsApi.updateWidgetSettings(request)
        .body()
        .apply { logger.info { this } }
}
