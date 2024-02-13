package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.BroadcastEventRequest
import co.novu.dto.request.BulkTriggerEventRequest
import co.novu.dto.request.TriggerEventRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.trigger(body: TriggerEventRequest): ResponseWrapper<TriggerResponse>? {
    val response = eventsApi.triggerEvent(body)
    return response.extractResponse(logger)
}

suspend fun Novu.bulkTrigger(body: BulkTriggerEventRequest): ResponseWrapper<List<TriggerResponse>>? {
    val response = eventsApi.bulkTriggerEvent(body)
    return response.extractResponse(logger)
}

suspend fun Novu.broadcast(body: BroadcastEventRequest): ResponseWrapper<TriggerResponse>? {
    val response = eventsApi.broadcastEvent(body)
    return response.extractResponse(logger)
}

suspend fun Novu.cancelTriggerEvent(transactionId: String): ResponseWrapper<Boolean>? {
    val response = eventsApi.cancelTriggerEvent(transactionId)
    return response.extractResponse(logger)
}
