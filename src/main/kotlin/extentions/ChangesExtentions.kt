package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.ChangesRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.changes(page: BigInteger? = null, limit: BigInteger? = null, promoted: String? = null) = runBlocking {
    val response = changesApi.getChanges(page, limit, promoted)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
fun Novu.changesCount() = runBlocking {
    val response = changesApi.getChangesCount()
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
fun Novu.applyBulkChanges(request: ChangesRequest) = runBlocking {
    val response = changesApi.applyBulkChanges(request)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.applyChange(changeId: String) = runBlocking {
    val response = changesApi.applyChange(changedId = changeId)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
