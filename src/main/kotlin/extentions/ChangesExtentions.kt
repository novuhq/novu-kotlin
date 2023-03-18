package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getChanges(page: BigInteger, limit: BigInteger, promoted: String) = runBlocking {
    changesApi.getChanges(page, limit, promoted)
        .body()
        .apply { logger.info { this } }
}
fun Novu.getChangesCount() = runBlocking {
    changesApi.getChangesCount()
        .body()
        .apply { logger.info { this } }
}
fun Novu.applyChanges() = runBlocking {
    changesApi.applyChanges()
        .body()
        .apply { logger.info { this } }
}

fun Novu.applychange(changeId: String) = runBlocking {
    changesApi.applyChange(changedId = changeId)
        .body()
        .apply { logger.info { this } }
}
