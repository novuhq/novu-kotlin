package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.MarkSubscriberFeedAsRequest
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.request.subscribers.UpdateSubscriberCredentialsRequest
import co.novu.dto.request.subscribers.UpdateSubscriberOnlineStatusRequest
import co.novu.dto.request.subscribers.UpdateSubscriberRequest
import co.novu.dto.response.UpdateSubscriberPreferencesRequest
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

fun Novu.updateSubscriberCredentials(subscriberId: String, request: UpdateSubscriberCredentialsRequest) = runBlocking {
    subscribersApi.updateSubscriberCredentials(subscriberId, request)
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

fun Novu.updateSubscriberPreferences(subscriberId: String, templateId: String, body: UpdateSubscriberPreferencesRequest) = runBlocking {
    subscribersApi.updateSubscriberPreferences(subscriberId, templateId, body)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getSubscriberNotificationsFeed(subscriberId: String) = runBlocking {
    subscribersApi.getSubscriberNotificationsFeed(subscriberId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getSubscriberUnseenNotificationsCount(subscriberId: String) = runBlocking {
    subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId)
        .body()
        .apply { logger.info { this } }
}
fun Novu.markSubscriberFeedAs(subscriberId: String, request: MarkSubscriberFeedAsRequest) = runBlocking {
    subscribersApi.markSubscriberMessageFeedAs(subscriberId, request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.markMessageActionAsSeen(subscriberId: String, messageId: String, type: String) = runBlocking {
    subscribersApi.markMessageActionAsSeen(subscriberId, messageId, type)
        .body()
        .apply { logger.info { this } }
}
