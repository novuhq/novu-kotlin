package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.FeedResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.createFeed(body: CreateByNameRequest): ResponseWrapper<FeedResponse>? {
    val response = feedsApi.createFeed(body)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.feeds(): ResponseWrapper<List<FeedResponse>>? {
    val response = feedsApi.getFeeds()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteFeed(feedId: String): ResponseWrapper<FeedResponse>? {
    val response = feedsApi.deleteFeed(feedId)
    return response.extractResponse(logger, config.enableLogging)
}
