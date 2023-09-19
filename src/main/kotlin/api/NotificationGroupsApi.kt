package co.novu.api

import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.DeleteWorkflowGroupResponse
import co.novu.dto.response.NotificationGroupsResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NotificationGroupsApi {
    @GET("notification-groups")
    suspend fun getNotificationGroups(): Response<ResponseWrapper<List<NotificationGroupsResponse>>>

    @POST("notification-groups")
    suspend fun createNotificationGroup(@Body request: CreateByNameRequest): Response<ResponseWrapper<NotificationGroupsResponse>>

    @GET("notification-groups/{id}")
    suspend fun getWorkflowGroup(@Path("id") id: String): Response<ResponseWrapper<NotificationGroupsResponse>>

    @PATCH("notification-groups/{id}")
    suspend fun updateWorkflowGroup(@Path("id") id: String, @Body request: CreateByNameRequest): Response<ResponseWrapper<NotificationGroupsResponse>>

    @DELETE("notification-groups/{id}")
    suspend fun deleteWorkflowGroup(@Path("id") id: String): Response<ResponseWrapper<DeleteWorkflowGroupResponse>>
}
