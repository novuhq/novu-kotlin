package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.request.CreateTopicRequest
import co.novu.dto.response.AddSubscribersResponse
import co.novu.dto.response.CheckTopicSubscriberResponse
import co.novu.dto.response.CreateTopicResponse
import co.novu.dto.response.DeleteTopicResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.RemoveSubscriberResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.SubscriberList
import co.novu.dto.response.TopicResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

suspend fun Novu.filterTopics(
    page: BigInteger? = null,
    pageSize: BigInteger? = null,
    key: String? = null,
): PaginatedResponseWrapper<TopicResponse>? {
    val response = topicsApi.filterTopics(page, pageSize, key)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createTopic(request: CreateTopicRequest): ResponseWrapper<CreateTopicResponse>? {
    val response = topicsApi.createTopic(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.addSubscribers(
    topicKey: String,
    request: SubscriberList,
): ResponseWrapper<AddSubscribersResponse>? {
    val response = topicsApi.addSubscriber(topicKey, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.removeSubscriber(
    topicKey: String,
    request: SubscriberList,
): RemoveSubscriberResponse {
    val response = topicsApi.removeSubscribers(topicKey, request)
    return response.extractResponse(logger, config.enableLogging, RemoveSubscriberResponse())
}

suspend fun Novu.checkSubscriber(
    topicKey: String,
    externalSubscriberId: String,
): CheckTopicSubscriberResponse? {
    val response = topicsApi.checkSubscriber(topicKey, externalSubscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.topic(topicKey: String): ResponseWrapper<TopicResponse>? {
    val response = topicsApi.getTopic(topicKey)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.renameTopic(
    topicKey: String,
    request: CreateByNameRequest,
): ResponseWrapper<TopicResponse>? {
    val response = topicsApi.renameTopic(topicKey, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteTopic(topicKey: String): DeleteTopicResponse {
    val response = topicsApi.deleteTopic(topicKey)
    return response.extractResponse(logger, config.enableLogging, DeleteTopicResponse())
}
