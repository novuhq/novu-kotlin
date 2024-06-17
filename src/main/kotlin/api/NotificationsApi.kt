package co.novu.api

import co.novu.dto.Notification
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface NotificationsApi {
    companion object {
        const val ENDPOINT = "notifications"
    }

    @GET(ENDPOINT)
    suspend fun getNotifications(
        @Query("channels") channels: List<String>?,
        @Query("templates") templates: List<String>?,
        @Query("emails") emails: List<String>?,
        @Query("search") search: String?,
        @Query("page") page: BigInteger?,
        @Query("transactionId") transactionId: String?,
    ): Response<PaginatedResponseWrapper<Notification>>

    @GET("$ENDPOINT/stats")
    suspend fun getNotificationsStats(): Response<ResponseWrapper<NotificationStatsResponse>>

    @GET("$ENDPOINT/graph/stats")
    suspend fun getNotificationGraphStats(): Response<ResponseWrapper<List<NotificationGraphStatsResponse>>>

    @GET("$ENDPOINT/{notificationId}")
    suspend fun getNotification(
        @Path("notificationId") notificationId: String,
    ): Response<ResponseWrapper<Notification>>
}
