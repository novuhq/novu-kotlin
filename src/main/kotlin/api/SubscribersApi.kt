package co.novu.api

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
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface SubscribersApi {

    companion object {
        const val ENDPOINT = "subscribers"
    }

    @GET(ENDPOINT)
    suspend fun getSubscribers(@Query("page") page: BigInteger?): Response<PaginatedResponseWrapper<SubscriberResponse>>

    @POST(ENDPOINT)
    suspend fun createSubscriber(@Body subscriberRequest: SubscriberRequest): Response<ResponseWrapper<SubscriberResponse>>

    @POST("$ENDPOINT/bulk")
    suspend fun createSubscriberBulk(@Body request: BulkSubscriberRequest): Response<CreateBulkSubscriberResponse>

    @GET("$ENDPOINT/{subscriberId}")
    suspend fun getSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<SubscriberResponse>>

    @PUT("$ENDPOINT/{subscriberId}")
    suspend fun updateSubscriber(@Path("subscriberId") subscriberId: String, @Body request: UpdateSubscriberRequest): Response<ResponseWrapper<SubscriberResponse>>

    @DELETE("$ENDPOINT/{subscriberId}")
    suspend fun deleteSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<SubscriberDeleteResponse>>

    @PUT("$ENDPOINT/{subscriberId}/credentials")
    suspend fun updateSubscriberCredentials(@Path("subscriberId") subscriberId: String, @Body request: UpdateSubscriberCredentialsRequest): Response<ResponseWrapper<SubscriberResponse>>

    @PATCH("$ENDPOINT/{subscriberId}/online-status")
    suspend fun updateSubscriberOnlineStatus(@Path("subscriberId")subscriberId: String, @Body request: UpdateSubscriberOnlineStatusRequest): Response<ResponseWrapper<SubscriberResponse>>

    @GET("$ENDPOINT/{subscriberId}/preferences")
    suspend fun getSubscriberPreferences(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<List<SubscriberPreferenceResponse>>>

    @PATCH("$ENDPOINT/{subscriberId}/preferences/{templateId}")
    suspend fun updateSubscriberPreferences(
        @Path("subscriberId") subscriberId: String,
        @Path("templateId") templateId: String,
        @Body request: UpdateSubscriberPreferencesRequest
    ): Response<ResponseWrapper<SubscriberPreferenceResponse>>

    @GET("$ENDPOINT/{subscriberId}/notifications/feed")
    suspend fun getSubscriberNotificationsFeed(@Path("subscriberId") subscriberId: String): Response<PaginatedResponseWrapper<SubscriberNotificationResponse>>

    @GET("$ENDPOINT/{subscriberId}/notifications/unseen")
    suspend fun getSubscriberUnseenNotificationsCount(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<UnseenNotificationsCountResponse>>

    @POST("$ENDPOINT/{subscriberId}/messages/markAs")
    suspend fun markSubscriberMessageFeedAs(
        @Path("subscriberId") subscriberId: String,
        @Body request: MarkSubscriberFeedAsRequest
    ): Response<ResponseWrapper<SubscriberNotificationResponse>>

    @POST("$ENDPOINT/{subscriberId}/messages/{messageId}/actions/{type}")
    suspend fun markMessageActionAsSeen(
        @Path("subscriberId") subscriberId: String,
        @Path("messageId") messageId: String,
        @Path("type") type: String,
        @Body request: MarkMessageActionAsSeenRequest
    ): Response<ResponseWrapper<SubscriberNotificationResponse>>
}
