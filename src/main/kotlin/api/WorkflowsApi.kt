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

    @GET("workflows")
    suspend fun getWorkflows(@Query("page") page: Int? = null, @Query("limit") limit: Int? = null): Response<PaginatedResponseWrapper<WorkflowResponse>>

    @POST("workflows")
    suspend fun createWorkflow(@Body request: WorkflowRequest): Response<ResponseWrapper<WorkflowResponse>>

    @PUT("workflows/{templateId}")
    suspend fun updateWorkflow(@Path("templateId") templateId: String, @Body request: UpdateWorkflowRequest): Response<ResponseWrapper<WorkflowResponse>>

    @DELETE("workflows/{templateId}")
    suspend fun deleteWorkflow(@Path("templateId") templateId: String): Response<ResponseWrapper<Boolean>>

    @GET("workflows/{templateId}")
    suspend fun getWorkflow(@Path("templateId") templateId: String): Response<ResponseWrapper<WorkflowResponse>>

    @PUT("workflows/{templateId}/status")
    suspend fun updateWorkflowStatus(@Path("templateId") templateId: String, @Body request: UpdateWorkflowStatusRequest): Response<ResponseWrapper<WorkflowResponse>>
}
