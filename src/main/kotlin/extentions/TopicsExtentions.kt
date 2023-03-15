package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.topics.CreateTopicRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getTopics(page: BigInteger, pageSize: BigInteger, key: String) = runBlocking {
    topicsApi.getTopics(page, pageSize, key)
        .body()
        .apply { logger.info { this } }
}

fun Novu.createTopic(request: CreateTopicRequest) = runBlocking {
    topicsApi.createTopic(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.addSubscriber(topicKey: String) = runBlocking {
    topicsApi.addSubscriber(topicKey)
        .body()
        .apply { logger.info { this } }
}

fun Novu.removeSubscriber(topicKey: String) = runBlocking {
    topicsApi.removeSubscriber(topicKey)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getTopic(topicKey: String) = runBlocking {
    topicsApi.getTopic(topicKey)
        .body()
        .apply { logger.info { this } }
}

fun Novu.renameTopic(topicKey: String) = runBlocking {
    topicsApi.renameTopic((topicKey))
        .body()
        .apply { logger.info { this } }
}
