package co.novu.extensions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.messages(channel: String? = null, subscriberId: String? = null, limit: BigInteger? = null, page: BigInteger? = null) = runBlocking {
    val response = messagesApi.getMessages(channel, subscriberId, limit, page)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.deleteMessage(messageId: String) = runBlocking {
    val response = messagesApi.deleteMessage(messageId)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
