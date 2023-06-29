package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.executionDetails(notificationId: String, subscriberId: String) = runBlocking {
    val response = executionDetailsApi.getExecutionDetails(notificationId, subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
