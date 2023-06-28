package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.createFeed(body: CreateByNameRequest) = runBlocking {
    val response = feedsApi.createFeed(body)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.feeds() = runBlocking {
    val response = feedsApi.getFeeds()
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.deleteFeed(feedId: String) = runBlocking {
    val response = feedsApi.deleteFeed(feedId)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
