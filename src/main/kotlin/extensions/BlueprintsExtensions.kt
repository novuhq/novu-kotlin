package co.novu.extensions

import co.novu.Novu
import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.response.ResponseWrapper
import mu.KotlinLogging
import java.lang.Exception

private val logger = KotlinLogging.logger {}

suspend fun Novu.getBlueprintsByCategory(): ResponseWrapper<BlueprintsResponse>? {
    val response = blueprintsApi.getBlueprintsByCategory()
    if (response.isSuccessful) {
        return response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

suspend fun Novu.getBlueprint(templateId: String): Blueprint? {
    val response = blueprintsApi.getBlueprint(templateId)
    if (response.isSuccessful) {
        return response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
