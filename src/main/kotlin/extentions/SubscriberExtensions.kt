package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.request.subscribers.UpdateSubscriberOnlineStatusRequest
import co.novu.dto.request.subscribers.UpdateSubscriberRequest
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
        .apply { logger.info { this } }
}

fun Novu.getSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.getSubscriber(subscriberId)
        .apply { logger.info { this } }
}

fun Novu.updateSubscriber(subscriberId: String, request: UpdateSubscriberRequest) = runBlocking {
    subscribersApi.updateSubscriber(subscriberId, request)
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

fun Novu.updateSubscriberOnlineStatus(subscriberId: String, isOnline: Boolean) = runBlocking {
    subscribersApi.updateSubscriberOnlineStatus(subscriberId, UpdateSubscriberOnlineStatusRequest(isOnline))
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
    subscribersApi.getNotificationFeedForSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getUnseenNotificationsForSubscriber(subscriberId: String) = runBlocking {
    subscribersApi.getUnseenNotificationsCountForSubscriber(subscriberId)
        .body()
        .apply { logger.info { this } }
}
fun Novu.markActionAsSeen(subscriberId: String, messageId: String, type: String) = runBlocking {
    subscribersApi.markActionAsSeen(subscriberId, messageId, type)
        .body()
        .apply { logger.info { this } }
}
