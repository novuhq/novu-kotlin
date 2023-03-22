package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Novu.createFeed(body: CreateByNameRequest) = runBlocking {
    feedsApi.createFeed(body)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getFeeds() = runBlocking {
    feedsApi.getFeeds()
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteFeed(feedId: String) = runBlocking {
    feedsApi.deleteFeed(feedId)
        .body()
        .apply { logger.info { this } }
}
