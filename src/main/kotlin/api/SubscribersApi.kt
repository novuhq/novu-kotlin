package co.novu.api

import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.request.MarkAsRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.subscribers.SubscriberResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.PATCH
import java.math.BigInteger

interface SubscribersApi {

    @GET("subscribers")
    suspend fun getSubscribers(@Query("page") page: BigInteger?): Response<PaginatedResponseWrapper<SubscriberResponse>>

    @POST("subscribers")
    suspend fun createSubscriber(@Body subscriberRequest: SubscriberRequest): Response<SubscriberResponse>

    @GET("subscribers/{subscriberId}")
    suspend fun getSubscriber(@Path("subscriberId") subscriberId: String): Response<Unit>

    @PUT("subscribers/{subscriberId}")
    suspend fun updateSubscriber(@Path("subscriberId") subscriberId: String): Response<Unit>

    @DELETE("subscribers/{subscriberId}")
    suspend fun deleteSubscriber(@Path("subscriberId") subscriberId: String): Response<Unit>

    @PUT("subscribers/{subscriberId}/credentials")
    suspend fun updateSubscriberCredentials(@Path("subscriberId") subscriberId: String): Response<Unit>

    @PATCH("subscribers/:subscriberId/online-status")
    suspend fun updateSubscriberOnlineStatus(@Path("subscriberId")subscriberId: String, @Body isOnline:Boolean): Response<Unit>

    @GET("subscribers/{subscriberId}/preferences")
    suspend fun getSubscriberPreferences(@Path("subscriberId") subscriberId: String): Response<Unit>

    @PUT("subscribers/{subscriberId}/preferences/{templateId}")
    suspend fun updateSubscriberPreferences(
        @Path("subscriberId") subscriberId: String,
        @Path("templateId") templateId: String,
    ): Response<Unit>

    @GET("subscribers/{subscriberId}/notifications/feed")
    suspend fun getNotificationsForSubscriber(@Path("subscriberId") subscriberId: String): Response<Unit>

    @GET("subscribers/{subscriberId}/notifications/unseen")
    suspend fun getUnseenNotificationsForSubscriber(@Path("subscriberId") subscriberId: String): Response<Unit>

    @POST("subscribers/{subscriberId}/messages/{messageId}/seen")
    suspend fun markSubscriberMessageFeedAsSeen(
        @Path("subscriberId") subscriberId: String,
        @Path("messageId") messageId: String,
    ): Response<Unit>

    @POST("subscribers/{subscriberId}/messages/markAs")
    suspend fun markSubscriberMessageFeedAs(
        @Path("subscriberId") subscriberId: String,
        @Body request: MarkAsRequest,
    ): Response<Unit>

    @POST()


    @POST("subscribers/{subscriberId}/messages/{messageId}/action/{type}")
    suspend fun markActionAsSeen(
        @Path("subscriberId") subscriberId: String,
        @Path("messageId") messageId: String,
        @Path("type") type: String,
    ): Response<Unit>
}
