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

/**
 * Retrieve all Subscribers associated with the API key provided. This function supports pagination.
 * @param page the page number to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.subscribers(page: BigInteger? = null): PaginatedResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.getSubscribers(page)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a Subscriber.
 * @param subscriberRequest an instance of [SubscriberRequest]
 * @return [ResponseWrapper] with [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createSubscriber(subscriberRequest: SubscriberRequest): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.createSubscriber(subscriberRequest)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create multiple Subscribers in a single transaction.
 * @param request an instance of [BulkSubscriberRequest]
 * @return [CreateBulkSubscriberResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createSubscriberBulk(request: BulkSubscriberRequest): CreateBulkSubscriberResponse? {
    val response = subscribersApi.createSubscriberBulk(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Subscriber.
 * @param subscriberId the ID of the Subscriber to be retrieved
 * @return [ResponseWrapper] with [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.subscriber(subscriberId: String): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.getSubscriber(subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Subscriber.
 * @param subscriberId the ID of the Subscriber to be updated
 * @param request an instance of [UpdateSubscriberRequest]
 * @return [ResponseWrapper] with [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateSubscriber(
    subscriberId: String,
    request: UpdateSubscriberRequest,
): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriber(subscriberId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Subscriber.
 * @param subscriberId the ID of the Subscriber to be deleted
 * @return [ResponseWrapper] with [SubscriberDeleteResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteSubscriber(subscriberId: String): ResponseWrapper<SubscriberDeleteResponse>? {
    val response = subscribersApi.deleteSubscriber(subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Subscriber's credentials.
 * @param subscriberId the ID of the Subscriber to be updated
 * @param request an instance of [UpdateSubscriberCredentialsRequest]
 * @return [ResponseWrapper] with [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateSubscriberCredentials(
    subscriberId: String,
    request: UpdateSubscriberCredentialsRequest,
): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriberCredentials(subscriberId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Subscriber's online status.
 * @param subscriberId the ID of the Subscriber to be updated
 * @param isOnline the online status of the Subscriber
 * @return [ResponseWrapper] with [SubscriberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateSubscriberOnlineStatus(
    subscriberId: String,
    isOnline: Boolean,
): ResponseWrapper<SubscriberResponse>? {
    val response = subscribersApi.updateSubscriberOnlineStatus(subscriberId, UpdateSubscriberOnlineStatusRequest(isOnline))
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Subscriber's preferences.
 * @param subscriberId the ID of the Subscriber whose preference is to be retrieved
 * @return [ResponseWrapper] with a list of [SubscriberPreferenceResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.subscriberPreferences(subscriberId: String): ResponseWrapper<List<SubscriberPreferenceResponse>>? {
    val response = subscribersApi.getSubscriberPreferences(subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Subscriber's preferences.
 * @param subscriberId the ID of the Subscriber to be updated
 * @param templateId the ID of the Template linked to the Subscriber
 * @param body an instance of [UpdateSubscriberPreferencesRequest]
 * @return [ResponseWrapper] with [SubscriberPreferenceResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateSubscriberPreferences(
    subscriberId: String,
    templateId: String,
    body: UpdateSubscriberPreferencesRequest,
): ResponseWrapper<SubscriberPreferenceResponse>? {
    val response = subscribersApi.updateSubscriberPreferences(subscriberId, templateId, body)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve all Notifications feed associated with a Subscriber. This function supports pagination.
 * @param subscriberId the ID of the Subscriber whose Notifications feed is to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [SubscriberNotificationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.subscriberNotificationsFeed(subscriberId: String): PaginatedResponseWrapper<SubscriberNotificationResponse>? {
    val response = subscribersApi.getSubscriberNotificationsFeed(subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Subscriber's unseen Notifications count.
 * @param subscriberId the ID of the Subscriber whose count is to be retrieved
 * @return [ResponseWrapper] with [UnseenNotificationsCountResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.subscriberUnseenNotificationsCount(subscriberId: String): ResponseWrapper<UnseenNotificationsCountResponse>? {
    val response = subscribersApi.getSubscriberUnseenNotificationsCount(subscriberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a particular Subscriber's Message feed (either read or seen).
 * @param subscriberId the ID of the Subscriber whose Message feed is to be updated
 * @param request an instance of [MarkSubscriberFeedAsRequest]
 * @return [ResponseWrapper] with a list of [SubscriberNotificationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.markSubscriberFeed(
    subscriberId: String,
    request: MarkSubscriberFeedAsRequest,
): ResponseWrapper<List<SubscriberNotificationResponse>>? {
    val response = subscribersApi.markSubscriberMessageFeedAs(subscriberId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update the action of a Message associated to a Subscriber.
 * @param subscriberId the ID of the Subscriber whose Message feed is to be updated
 * @param messageId the ID of the Message to be updated
 * @param type the type of action to be performed
 * @param request an instance of [MarkMessageActionAsSeenRequest]
 * @return [ResponseWrapper] with [SubscriberNotificationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.markMessageActionSeen(
    subscriberId: String,
    messageId: String,
    type: String,
    request: MarkMessageActionAsSeenRequest,
): ResponseWrapper<SubscriberNotificationResponse>? {
    val response = subscribersApi.markMessageActionAsSeen(subscriberId, messageId, type, request)
    return response.extractResponse(logger, config.enableLogging)
}
