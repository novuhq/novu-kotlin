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

/**
 * Retrieve a list of Topics filtered by a Topic key. This function supports pagination.
 * @param page the page number to be retrieved
 * @param pageSize the size of the page to be retrieved
 * @param key the key of the Topics to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [TopicResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.filterTopics(
    page: BigInteger? = null,
    pageSize: BigInteger? = null,
    key: String? = null,
): PaginatedResponseWrapper<TopicResponse>? {
    val response = topicsApi.filterTopics(page, pageSize, key)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a Topic.
 * @param request an instance of [CreateTopicRequest]
 * @return [ResponseWrapper] with [CreateTopicResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createTopic(request: CreateTopicRequest): ResponseWrapper<CreateTopicResponse>? {
    val response = topicsApi.createTopic(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Add Subscribers to a Topic.
 * @param topicKey the key of the Topic which the Subscriber should be added to
 * @param request an instance of [SubscriberList]
 * @return [ResponseWrapper] with [AddSubscribersResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.addSubscribers(
    topicKey: String,
    request: SubscriberList,
): ResponseWrapper<AddSubscribersResponse>? {
    val response = topicsApi.addSubscriber(topicKey, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Remove Subscribers from a Topic.
 * @param topicKey the key of the Topic which the Subscriber should be removed from
 * @param request an instance of [SubscriberList]
 * @return [RemoveSubscriberResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.removeSubscriber(
    topicKey: String,
    request: SubscriberList,
): RemoveSubscriberResponse {
    val response = topicsApi.removeSubscribers(topicKey, request)
    return response.extractResponse(logger, config.enableLogging, RemoveSubscriberResponse())
}

/**
 * Check if a Subscriber belongs to a Topic.
 * @param topicKey the key of the Topic to be checked
 * @param externalSubscriberId the ID of the Subscriber
 * @return [CheckTopicSubscriberResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.checkSubscriber(
    topicKey: String,
    externalSubscriberId: String,
): CheckTopicSubscriberResponse? {
    val response = topicsApi.checkSubscriber(topicKey, externalSubscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Topic.
 * @param topicKey the key of the Topic to be retrieved
 * @return [ResponseWrapper] with [TopicResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.topic(topicKey: String): ResponseWrapper<TopicResponse>? {
    val response = topicsApi.getTopic(topicKey)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Rename a Topic.
 * @param topicKey the key of the Topic to be renamed
 * @param request an instance of [CreateByNameRequest]
 * @return [ResponseWrapper] with [TopicResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.renameTopic(
    topicKey: String,
    request: CreateByNameRequest,
): ResponseWrapper<TopicResponse>? {
    val response = topicsApi.renameTopic(topicKey, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Topic.
 * @param topicKey the key of the Topic to be deleted
 * @return [DeleteTopicResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteTopic(topicKey: String): DeleteTopicResponse {
    val response = topicsApi.deleteTopic(topicKey)
    return response.extractResponse(logger, config.enableLogging, DeleteTopicResponse())
}
