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

/**
 * Trigger an event such as sending notification to subscribers.
 * @param body an instance of [TriggerEventRequest]
 * @return [ResponseWrapper] with [TriggerResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.trigger(body: TriggerEventRequest): ResponseWrapper<TriggerResponse>? {
    val response = eventsApi.triggerEvent(body)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Trigger multiple events in a single transaction.
 * @param body an instance of [BulkTriggerEventRequest]
 * @return [ResponseWrapper] with a list of [TriggerResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.bulkTrigger(body: BulkTriggerEventRequest): ResponseWrapper<List<TriggerResponse>>? {
    val response = eventsApi.bulkTriggerEvent(body)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Broadcast an event to all existing subscribers.
 * @param body an instance of [BroadcastEventRequest]
 * @return [ResponseWrapper] with [TriggerResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.broadcast(body: BroadcastEventRequest): ResponseWrapper<TriggerResponse>? {
    val response = eventsApi.broadcastEvent(body)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Cancel a running event.
 * @param transactionId the transaction ID of the running event
 * @return [ResponseWrapper] with [Boolean] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.cancelTriggerEvent(transactionId: String): ResponseWrapper<Boolean>? {
    val response = eventsApi.cancelTriggerEvent(transactionId)
    return response.extractResponse(logger, config.enableLogging)
}
