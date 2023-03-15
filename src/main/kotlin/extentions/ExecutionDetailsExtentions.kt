package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.getExecutionDetails(notificationId: String, subscriberId: String) = runBlocking {
    executionDetailsApi.getExecutionDetails(notificationId, subscriberId)
        .body()
        .apply { logger.info { this } }
}
