package co.novu.extentions

import co.novu.Novu
import co.novu.dto.Widget
import co.novu.dto.request.CreateEnvironmentRequest
import co.novu.dto.request.UpdateEnvironmentRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.currentEnvironment() = runBlocking {
    val response = environmentsApi.getCurrentEnvironment()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.createEnvironment(request: CreateEnvironmentRequest) = runBlocking {
    val response = environmentsApi.createEnvironment(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.environments() = runBlocking {
    val response = environmentsApi.getEnvironments()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.updateEnvironment(environmentId: String, request: UpdateEnvironmentRequest) = runBlocking {
    val response = environmentsApi.updateEnvironment(environmentId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.apiKeys() = runBlocking {
    val response = environmentsApi.getApiKeys()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.regenrateApiKey() = runBlocking {
    val response = environmentsApi.regenerateApiKey()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.updateWidgetSettings(request: Widget) = runBlocking {
    val response = environmentsApi.updateWidgetSettings(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
