package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.FeedResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Create a Feed.
 * @param body an instance of [CreateByNameRequest]
 * @return [ResponseWrapper] with [FeedResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createFeed(body: CreateByNameRequest): ResponseWrapper<FeedResponse>? {
    val response = feedsApi.createFeed(body)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of Feeds.
 * @return [ResponseWrapper] with a list of [FeedResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.feeds(): ResponseWrapper<List<FeedResponse>>? {
    val response = feedsApi.getFeeds()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Feed.
 * @param feedId the ID of the Feed to be deleted
 * @return [ResponseWrapper] with [FeedResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteFeed(feedId: String): ResponseWrapper<FeedResponse>? {
    val response = feedsApi.deleteFeed(feedId)
    return response.extractResponse(logger, config.enableLogging)
}
