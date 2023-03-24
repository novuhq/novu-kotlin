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
    val response = subscribersApi.getSubscribers(page)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.createSubscriber(subscriberRequest: SubscriberRequest) = runBlocking {
    val response = subscribersApi.createSubscriber(subscriberRequest)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.subscriber(subscriberId: String) = runBlocking {
    val response = subscribersApi.getSubscriber(subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateSubscriber(subscriberId: String, request: UpdateSubscriberRequest) = runBlocking {
    val response = subscribersApi.updateSubscriber(subscriberId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.deleteSubscriber(subscriberId: String) = runBlocking {
    val response = subscribersApi.deleteSubscriber(subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateSubscriberCredentials(subscriberId: String, request: UpdateSubscriberCredentialsRequest) = runBlocking {
    val response = subscribersApi.updateSubscriberCredentials(subscriberId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateSubscriberOnlineStatus(subscriberId: String, isOnline: Boolean) = runBlocking {
    val response = subscribersApi.updateSubscriberOnlineStatus(subscriberId, UpdateSubscriberOnlineStatusRequest(isOnline))
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.subscriberPreferences(subscriberId: String) = runBlocking {
    val response = subscribersApi.getSubscriberPreferences(subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.updateSubscriberPreferences(subscriberId: String, templateId: String, body: UpdateSubscriberPreferencesRequest) = runBlocking {
    val response = subscribersApi.updateSubscriberPreferences(subscriberId, templateId, body)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.subscriberNotificationsFeed(subscriberId: String) = runBlocking {
    val response = subscribersApi.getSubscriberNotificationsFeed(subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.subscriberUnseenNotificationsCount(subscriberId: String) = runBlocking {
    val response = subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
fun Novu.markSubscriberFeed(subscriberId: String, request: MarkSubscriberFeedAsRequest) = runBlocking {
    val response = subscribersApi.markSubscriberMessageFeedAs(subscriberId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}

fun Novu.markMessageActionSeen(subscriberId: String, messageId: String, type: String) = runBlocking {
    val response = subscribersApi.markMessageActionAsSeen(subscriberId, messageId, type)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        response.errorBody()?.string().apply { logger.error { this } }
    }
}
