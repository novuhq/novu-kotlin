package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.request.topics.CreateTopicRequest
import co.novu.dto.response.SubscriberList
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.filterTopics(page: BigInteger? = null, pageSize: BigInteger? = null, key: String? = null) = runBlocking {
    val response = topicsApi.filterTopics(page, pageSize, key)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.createTopic(request: CreateTopicRequest) = runBlocking {
    val response = topicsApi.createTopic(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.addSubscribers(topicKey: String, request: SubscriberList) = runBlocking {
    val response = topicsApi.addSubscriber(topicKey, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.removeSubscriber(topicKey: String, request: SubscriberList) = runBlocking {
    val response = topicsApi.removeSubscribers(topicKey, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.topic(topicKey: String) = runBlocking {
    val response = topicsApi.getTopic(topicKey)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.renameTopic(topicKey: String, request: CreateByNameRequest) = runBlocking {
    val response = topicsApi.renameTopic(topicKey, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
