package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.BroadcastEventRequest
import co.novu.dto.request.BulkTriggerEventRequest
import co.novu.dto.request.TriggerEventRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.trigger(body: TriggerEventRequest) = runBlocking {
    val response = eventsApi.triggerEvent(body)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.bulkTrigger(body: BulkTriggerEventRequest) = runBlocking {
    val response = eventsApi.bulkTriggerEvent(body)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.broadcast(body: BroadcastEventRequest) = runBlocking {
    val response = eventsApi.broadcastEvent(body)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.cancelTriggerEvent(transactionId: String) = runBlocking {
    val response = eventsApi.cancelTriggerEvent(transactionId)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
