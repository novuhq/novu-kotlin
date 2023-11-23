package co.novu.api

import co.novu.dto.request.UpdateWorkflowRequest
import co.novu.dto.request.UpdateWorkflowStatusRequest
import co.novu.dto.request.WorkflowRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.WorkflowResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface WorkflowsApi {

    companion object {
        const val ENDPOINT = "workflows"
    }

    @GET(ENDPOINT)
    suspend fun getWorkflows(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<PaginatedResponseWrapper<WorkflowResponse>>

    @POST(ENDPOINT)
    suspend fun createWorkflow(@Body request: WorkflowRequest): Response<ResponseWrapper<WorkflowResponse>>

    @PUT("$ENDPOINT/{workflowId}")
    suspend fun updateWorkflow(@Path("workflowId") workflowId: String, @Body request: UpdateWorkflowRequest): Response<ResponseWrapper<WorkflowResponse>>

    @DELETE("$ENDPOINT/{workflowId}")
    suspend fun deleteWorkflow(@Path("workflowId") workflowId: String): Response<ResponseWrapper<Boolean>>

    @GET("$ENDPOINT/{workflowId}")
    suspend fun getWorkflow(@Path("workflowId") workflowId: String): Response<ResponseWrapper<WorkflowResponse>>

    @PUT("$ENDPOINT/{workflowId}/status")
    suspend fun updateWorkflowStatus(@Path("workflowId") workflowId: String, @Body request: UpdateWorkflowStatusRequest): Response<ResponseWrapper<WorkflowResponse>>
}
