package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getMessages(channel: String? = null, subscriberId: String? = null, limit: BigInteger? = null, page: BigInteger? = null) = runBlocking {
    val response = messagesApi.getMessages(channel, subscriberId, limit, page)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.deleteMessage(messageId: String) = runBlocking {
    val response = messagesApi.deleteMessage(messageId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
