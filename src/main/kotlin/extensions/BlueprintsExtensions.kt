package co.novu.extensions

import co.novu.Novu
import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.getBlueprintsByCategory(): ResponseWrapper<BlueprintsResponse>? {
    val response = blueprintsApi.getBlueprintsByCategory()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getBlueprint(templateId: String): Blueprint? {
    val response = blueprintsApi.getBlueprint(templateId)
    return response.extractResponse(logger, config.enableLogging)
}
