package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.BulkSubscriberRequest
import co.novu.dto.request.MarkMessageActionAsSeenRequest
import co.novu.dto.request.MarkSubscriberFeedAsRequest
import co.novu.dto.request.SubscriberRequest
import co.novu.dto.request.UpdateSubscriberCredentialsRequest
import co.novu.dto.request.UpdateSubscriberOnlineStatusRequest
import co.novu.dto.request.UpdateSubscriberRequest
import co.novu.dto.response.CreateBulkSubscriberResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.SubscriberDeleteResponse
import co.novu.dto.response.SubscriberNotificationResponse
import co.novu.dto.response.SubscriberPreferenceResponse
import co.novu.dto.response.SubscriberResponse
import co.novu.dto.response.UnseenNotificationsCountResponse
import co.novu.dto.response.UpdateSubscriberPreferencesRequest
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

suspend fun Novu.subscribers(page: BigInteger? = null): PaginatedResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.getSubscribers(page)
    return response.extractResponse(logger)
}

suspend fun Novu.createSubscriber(subscriberRequest: SubscriberRequest): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.createSubscriber(subscriberRequest)
    return response.extractResponse(logger)
}

suspend fun Novu.createSubscriberBulk(request: BulkSubscriberRequest): CreateBulkSubscriberResponse? {
    val response = subscribersApi.createSubscriberBulk(request)
    return response.extractResponse(logger)
}

suspend fun Novu.subscriber(subscriberId: String): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.getSubscriber(subscriberId)
    return response.extractResponse(logger)
}

suspend fun Novu.updateSubscriber(subscriberId: String, request: UpdateSubscriberRequest): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriber(subscriberId, request)
    return response.extractResponse(logger)
}

suspend fun Novu.deleteSubscriber(subscriberId: String): ResponseWrapper<SubscriberDeleteResponse>? {
    val response = subscribersApi.deleteSubscriber(subscriberId)
    return response.extractResponse(logger)
}

suspend fun Novu.updateSubscriberCredentials(subscriberId: String, request: UpdateSubscriberCredentialsRequest): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriberCredentials(subscriberId, request)
    return response.extractResponse(logger)
}

suspend fun Novu.updateSubscriberOnlineStatus(subscriberId: String, isOnline: Boolean): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriberOnlineStatus(subscriberId, UpdateSubscriberOnlineStatusRequest(isOnline))
    return response.extractResponse(logger)
}

suspend fun Novu.subscriberPreferences(subscriberId: String): ResponseWrapper<List<SubscriberPreferenceResponse>>? {
    val response = subscribersApi.getSubscriberPreferences(subscriberId)
    return response.extractResponse(logger)
}

suspend fun Novu.updateSubscriberPreferences(subscriberId: String, templateId: String, body: UpdateSubscriberPreferencesRequest): ResponseWrapper<SubscriberPreferenceResponse>? {
    val response = subscribersApi.updateSubscriberPreferences(subscriberId, templateId, body)
    return response.extractResponse(logger)
}

suspend fun Novu.subscriberNotificationsFeed(subscriberId: String): PaginatedResponseWrapper<SubscriberNotificationResponse>? {
    val response = subscribersApi.getSubscriberNotificationsFeed(subscriberId)
    return response.extractResponse(logger)
}

suspend fun Novu.subscriberUnseenNotificationsCount(subscriberId: String): ResponseWrapper<UnseenNotificationsCountResponse>? {
    val response = subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId)
    return response.extractResponse(logger)
}

suspend fun Novu.markSubscriberFeed(subscriberId: String, request: MarkSubscriberFeedAsRequest): ResponseWrapper<SubscriberNotificationResponse>? {
    val response = subscribersApi.markSubscriberMessageFeedAs(subscriberId, request)
    return response.extractResponse(logger)
}

suspend fun Novu.markMessageActionSeen(subscriberId: String, messageId: String, type: String, request: MarkMessageActionAsSeenRequest): ResponseWrapper<SubscriberNotificationResponse>? {
    val response = subscribersApi.markMessageActionAsSeen(subscriberId, messageId, type, request)
    return response.extractResponse(logger)
}
