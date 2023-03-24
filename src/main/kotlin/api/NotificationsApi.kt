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

interface NotificationsApi {

    @GET("notifications")
    suspend fun getNotifications(
        @Query("channels") channels: List<String>?,
        @Query("templates") templates: List<String>?,
        @Query("emails") emails: List<String>?,
        @Query("search") search: String?,
        @Query("page") page: String?,
        @Query("transactionId") transactionId: String?
    ): Response<PaginatedResponseWrapper<Notification>>

    @GET("notifications/stats")
    suspend fun getNotificationsStats(): Response<ResponseWrapper<NotificationStatsResponse>>

    @GET("notifications/graph/stats")
    suspend fun getNotificationGraphStats(): Response<ResponseWrapper<List<NotificationGraphStatsResponse>>>

    @GET("notifications/{notificationId}")
    suspend fun getNotification(@Path("notificationId") notificationId: String): Response<ResponseWrapper<Notification>>
}
