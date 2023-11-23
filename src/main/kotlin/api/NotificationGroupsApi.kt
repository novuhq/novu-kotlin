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

    companion object {
        const val ENDPOINT = "notification-groups"
    }

    @GET(ENDPOINT)
    suspend fun getNotificationGroups(): Response<ResponseWrapper<List<NotificationGroupsResponse>>>

    @POST(ENDPOINT)
    suspend fun createNotificationGroup(@Body request: CreateByNameRequest): Response<ResponseWrapper<NotificationGroupsResponse>>

    @GET("$ENDPOINT/{id}")
    suspend fun getWorkflowGroup(@Path("id") id: String): Response<ResponseWrapper<NotificationGroupsResponse>>

    @PATCH("$ENDPOINT/{id}")
    suspend fun updateWorkflowGroup(@Path("id") id: String, @Body request: CreateByNameRequest): Response<ResponseWrapper<NotificationGroupsResponse>>

    @DELETE("$ENDPOINT/{id}")
    suspend fun deleteWorkflowGroup(@Path("id") id: String): Response<ResponseWrapper<DeleteWorkflowGroupResponse>>
}
