package co.novu.extensions

import co.novu.Novu
import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Blueprints grouped by Category.
 * @return [ResponseWrapper] with [BlueprintsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getBlueprintsByCategory(): ResponseWrapper<BlueprintsResponse>? {
    val response = blueprintsApi.getBlueprintsByCategory()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Blueprint.
 * @param templateId the ID of a Template
 * @return [Blueprint]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getBlueprint(templateId: String): Blueprint? {
    val response = blueprintsApi.getBlueprint(templateId)
    return response.extractResponse(logger, config.enableLogging)
}
