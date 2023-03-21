package co.novu.api

import co.novu.dto.request.MarkSubscriberFeedAsRequest
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.request.subscribers.UpdateSubscriberCredentialsRequest
import co.novu.dto.request.subscribers.UpdateSubscriberOnlineStatusRequest
import co.novu.dto.request.subscribers.UpdateSubscriberRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.UnseenNotificationsCountResponse
import co.novu.dto.response.UpdateSubscriberPreferencesRequest
import co.novu.dto.response.subscribers.SubscriberDeleteResponse
import co.novu.dto.response.subscribers.SubscriberNotificationResponse
import co.novu.dto.response.subscribers.SubscriberPreferenceResponse
import co.novu.dto.response.subscribers.SubscriberResponse
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

    @GET("subscribers")
    suspend fun getSubscribers(@Query("page") page: BigInteger?): Response<PaginatedResponseWrapper<SubscriberResponse>>

    @POST("subscribers")
    suspend fun createSubscriber(@Body subscriberRequest: SubscriberRequest): Response<ResponseWrapper<SubscriberResponse>>

    @GET("subscribers/{subscriberId}")
    suspend fun getSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<SubscriberResponse>>

    @PUT("subscribers/{subscriberId}")
    suspend fun updateSubscriber(@Path("subscriberId") subscriberId: String, @Body request: UpdateSubscriberRequest): Response<ResponseWrapper<SubscriberResponse>>

    @DELETE("subscribers/{subscriberId}")
    suspend fun deleteSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<SubscriberDeleteResponse>>

    @PUT("subscribers/{subscriberId}/credentials")
    suspend fun updateSubscriberCredentials(@Path("subscriberId") subscriberId: String, @Body request: UpdateSubscriberCredentialsRequest): Response<ResponseWrapper<SubscriberResponse>>

    @PATCH("subscribers/{subscriberId}/online-status")
    suspend fun updateSubscriberOnlineStatus(@Path("subscriberId")subscriberId: String, @Body request: UpdateSubscriberOnlineStatusRequest): Response<ResponseWrapper<SubscriberResponse>>

    @GET("subscribers/{subscriberId}/preferences")
    suspend fun getSubscriberPreferences(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<SubscriberPreferenceResponse>>

    @PUT("subscribers/{subscriberId}/preferences/{templateId}")
    suspend fun updateSubscriberPreferences(
        @Path("subscriberId") subscriberId: String,
        @Path("templateId") templateId: String,
        @Body request: UpdateSubscriberPreferencesRequest
    ): Response<ResponseWrapper<SubscriberPreferenceResponse>>

    @GET("subscribers/{subscriberId}/notifications/feed")
    suspend fun getNotificationFeedForSubscriber(@Path("subscriberId") subscriberId: String): Response<PaginatedResponseWrapper<SubscriberNotificationResponse>>

    @GET("subscribers/{subscriberId}/notifications/unseen")
    suspend fun getUnseenNotificationsCountForSubscriber(@Path("subscriberId") subscriberId: String): Response<UnseenNotificationsCountResponse>

    @POST("subscribers/{subscriberId}/messages/markAs")
    suspend fun markSubscriberMessageFeedAs(
        @Path("subscriberId") subscriberId: String,
        @Body request: MarkSubscriberFeedAsRequest,
    ): Response<SubscriberNotificationResponse>

    @POST("subscribers/{subscriberId}/messages/{messageId}/actions/{type}")
    suspend fun markMessageActionAsSeen(
        @Path("subscriberId") subscriberId: String,
        @Path("messageId") messageId: String,
        @Path("type") type: String,
    ): Response<SubscriberNotificationResponse>
}
