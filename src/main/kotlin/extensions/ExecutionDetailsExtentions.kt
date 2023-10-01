package co.novu.extensions

import co.novu.Novu
import co.novu.dto.ExecutionDetails
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.executionDetails(notificationId: String, subscriberId: String): ResponseWrapper<List<ExecutionDetails>>? {
    val response = executionDetailsApi.getExecutionDetails(notificationId, subscriberId)
    return response.extractResponse(logger)
}
