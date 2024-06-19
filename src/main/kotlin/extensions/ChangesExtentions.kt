package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.ChangesRequest
import co.novu.dto.response.ChangesResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Changes. This function supports pagination.
 * @param page the page number to be retrieved
 * @param limit the size of the page to be retrieved
 * @param promoted the state of the Changes to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [ChangesResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.changes(
    page: BigInteger? = null,
    limit: BigInteger? = null,
    promoted: String? = null,
): PaginatedResponseWrapper<ChangesResponse>? {
    val response = changesApi.getChanges(page, limit, promoted)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve the count of all available Changes.
 * @return [ResponseWrapper] with [BigInteger] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.changesCount(): ResponseWrapper<BigInteger>? {
    val response = changesApi.getChangesCount()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Apply a list of Changes.
 * @param request an instance of [ChangesRequest]
 * @return [ResponseWrapper] with a list of [ChangesResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.applyBulkChanges(request: ChangesRequest): ResponseWrapper<List<ChangesResponse>>? {
    val response = changesApi.applyBulkChanges(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Apply a particular Change.
 * @param changeId the ID of the Change to be applied
 * @return [ResponseWrapper] with a list of [ChangesResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.applyChange(changeId: String): ResponseWrapper<List<ChangesResponse>>? {
    val response = changesApi.applyChange(changedId = changeId)
    return response.extractResponse(logger, config.enableLogging)
}
