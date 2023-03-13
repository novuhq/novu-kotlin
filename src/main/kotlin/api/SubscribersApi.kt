package co.novu.api

import co.novu.dto.request.MarkAsRequest
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.request.subscribers.UpdateSubscriberRequest
import co.novu.dto.request.subscribers.UpdateSubscriberOnlineStatusRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.subscribers.SubscriberDeleteResponse
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
    suspend fun updateSubscriberCredentials(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<Any>>

    @PATCH("subscribers/{subscriberId}/online-status")
    suspend fun updateSubscriberOnlineStatus(@Path("subscriberId")subscriberId: String, @Body request: UpdateSubscriberOnlineStatusRequest): Response<ResponseWrapper<SubscriberResponse>>

    @GET("subscribers/{subscriberId}/preferences")
    suspend fun getSubscriberPreferences(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<List<SubscriberPreferenceResponse>>>

    @PUT("subscribers/{subscriberId}/preferences/{templateId}")
    suspend fun updateSubscriberPreferences(
        @Path("subscriberId") subscriberId: String,
        @Path("templateId") templateId: String,
    ): Response<Any>

    @GET("subscribers/{subscriberId}/notifications/feed")
    suspend fun getNotificationsForSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<Any>>

    @GET("subscribers/{subscriberId}/notifications/unseen")
    suspend fun getUnseenNotificationsForSubscriber(@Path("subscriberId") subscriberId: String): Response<ResponseWrapper<Any>>

    @POST("subscribers/{subscriberId}/messages/markAs")
    suspend fun markSubscriberMessageFeedAs(
        @Path("subscriberId") subscriberId: String,
        @Body request: MarkAsRequest,
    ): Response<ResponseWrapper<Any>>

    @POST("subscribers/{subscriberId}/messages/{messageId}/action/{type}")
    suspend fun markActionAsSeen(
        @Path("subscriberId") subscriberId: String,
        @Path("messageId") messageId: String,
        @Path("type") type: String,
    ): Response<ResponseWrapper<Any>>
}
