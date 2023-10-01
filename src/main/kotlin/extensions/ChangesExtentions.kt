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

suspend fun Novu.changes(page: BigInteger? = null, limit: BigInteger? = null, promoted: String? = null): PaginatedResponseWrapper<ChangesResponse>? {
    val response = changesApi.getChanges(page, limit, promoted)
    return response.extractResponse(logger)
}

suspend fun Novu.changesCount(): ResponseWrapper<BigInteger>? {
    val response = changesApi.getChangesCount()
    return response.extractResponse(logger)
}

suspend fun Novu.applyBulkChanges(request: ChangesRequest): ResponseWrapper<List<ChangesResponse>>? {
    val response = changesApi.applyBulkChanges(request)
    return response.extractResponse(logger)
}

suspend fun Novu.applyChange(changeId: String): ResponseWrapper<List<ChangesResponse>>? {
    val response = changesApi.applyChange(changedId = changeId)
    return response.extractResponse(logger)
}
