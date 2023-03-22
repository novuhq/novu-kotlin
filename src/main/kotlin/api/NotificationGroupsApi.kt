package co.novu.api

import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.NotificationGroupsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NotificationGroupsApi {
    @GET("notification-groups")
    suspend fun getNotificationGroups(): Response<NotificationGroupsResponse>

    @POST("notification-groups")
    suspend fun createNotificationGroup(@Body request: CreateByNameRequest): Response<NotificationGroupsResponse>
}
