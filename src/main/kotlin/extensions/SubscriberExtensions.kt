package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.subscribers.SubscriberRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.subscribers(page: BigInteger? = null) = runBlocking {
    subscribersApi.getSubscribers(page)
        .body()
        .apply { logger.info { this } }
}

fun Novu.createSubscriber(subscriberRequest: SubscriberRequest) = runBlocking {
    subscribersApi.createSubscriber(subscriberRequest)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.getSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.updateSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.deleteSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateSubscriberCredentials(subscriberId: String) = runBlocking {
    subscribersApi.updateSubscriberCredentials(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getSubscriberPreferences(subscriberId: String) = runBlocking {
    subscribersApi.getSubscriberPreferences(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.updateSubscriberPreferences(subscriberId: String, templateId: String) = runBlocking {
    subscribersApi.updateSubscriberPreferences(subscriberId, templateId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getNotificationsForSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.getNotificationsForSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getUnseenNotificationsForSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.getUnseenNotificationsForSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.markSubscriberMessageFeedAsSeen(subscriberId: String, messageId: String) = runBlocking {
    subscribersApi.markSubscriberMessageFeedAsSeen(subscriberId, messageId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.markActionAsSeen(subscriberId: String, messageId: String, type: String) = runBlocking {
    subscribersApi.markActionAsSeen(subscriberId, messageId, type)
        .body()
        .apply { logger.info { this } }
}
