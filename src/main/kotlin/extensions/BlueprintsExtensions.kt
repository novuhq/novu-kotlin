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
    response.apply {
        return if (isSuccessful) {
            body().apply { logger.debug { this } }
        } else {
            throw Exception(errorBody()?.string())
        }
    }
}

suspend fun Novu.getBlueprint(templateId: String): Blueprint? {
    val response = blueprintsApi.getBlueprint(templateId)
    response.apply {
        return if (isSuccessful) {
            body().apply { logger.debug { this } }
        } else {
            throw Exception(errorBody()?.string())
        }
    }
}
