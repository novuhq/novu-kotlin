package co.novu.extensions

import co.novu.Novu
import co.novu.dto.response.Message
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

suspend fun Novu.messages(
    channel: String? = null,
    subscriberId: String? = null,
    limit: BigInteger? = null,
    page: BigInteger? = null,
    transactionId: String? = null
): PaginatedResponseWrapper<Message>? {
    val response = messagesApi.getMessages(channel, subscriberId, limit, page, transactionId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteMessage(messageId: String): ResponseWrapper<TriggerResponse>? {
    val response = messagesApi.deleteMessage(messageId)
    return response.extractResponse(logger, config.enableLogging)
}
