package co.novu.extensions

import co.novu.Novu
import co.novu.dto.ExecutionDetails
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Execution Details.
 * @param notificationId the ID of a Notification
 * @param subscriberId the ID of a Subscriber
 * @return [ResponseWrapper] with a list of [ExecutionDetails] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.executionDetails(
    notificationId: String,
    subscriberId: String,
): ResponseWrapper<List<ExecutionDetails>>? {
    val response = executionDetailsApi.getExecutionDetails(notificationId, subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}
