package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getMessages(channel: String, subscriberId: String, limit: BigInteger, page: BigInteger) = runBlocking {
    messagesApi.getMessages(channel, subscriberId, limit, page)
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteMessage(messageId: String) = runBlocking {
    messagesApi.deleteMessage(messageId)
        .body()
        .apply { logger.info { this } }
}
