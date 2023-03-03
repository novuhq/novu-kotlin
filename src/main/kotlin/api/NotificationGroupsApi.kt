package co.novu.api

import co.novu.dto.response.NotificationGroupsResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NotificationGroupsApi {
    @GET("notification-groups")
    suspend fun getNotificationGroups(): Response<ResponseWrapper<NotificationGroupsResponse>>

    @POST("notification-groups")
    suspend fun createNotificationGroup(@Body name: String): Response<ResponseWrapper<NotificationGroupsResponse>>
}