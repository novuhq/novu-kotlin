package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.getExecutionDetails(notificationId: String, subscriberId: String) = runBlocking {
    val response = executionDetailsApi.getExecutionDetails(notificationId, subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
