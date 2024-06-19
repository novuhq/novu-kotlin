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

/**
 * Retrieve a list of Messages. This function supports pagination.
 * @param channel the channel of the Messages to be retrieved
 * @param subscriberId the ID of the Subscriber who owns the Messages
 * @param limit the size of the page to be retrieved
 * @param page the page number to be retrieved
 * @param transactionId the transaction ID of the Messages to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [Message] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.messages(
    channel: String? = null,
    subscriberId: String? = null,
    limit: BigInteger? = null,
    page: BigInteger? = null,
    transactionId: String? = null,
): PaginatedResponseWrapper<Message>? {
    val response = messagesApi.getMessages(channel, subscriberId, limit, page, transactionId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Message.
 * @param messageId the ID of the Message to be deleted
 * @return [ResponseWrapper] with a list of [TriggerResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteMessage(messageId: String): ResponseWrapper<TriggerResponse>? {
    val response = messagesApi.deleteMessage(messageId)
    return response.extractResponse(logger, config.enableLogging)
}
