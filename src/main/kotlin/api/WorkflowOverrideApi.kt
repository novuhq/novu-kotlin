package api

import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import dto.request.CreateWorkflowOverrideRequest
import dto.workflowoverrides.UpdateWorkflowOverrideRequest
import dto.workflowoverrides.WorkflowOverride
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface WorkflowOverrideApi {
    companion object {
        const val ENDPOINT = "workflow-overrides"
    }

    @POST(ENDPOINT)
    suspend fun createWorkflowOverride(
        @Body request: CreateWorkflowOverrideRequest,
    ): Response<ResponseWrapper<WorkflowOverride>>

    @GET(ENDPOINT)
    @JvmSuppressWildcards
    suspend fun getWorkflowOverrides(
        @QueryMap params: Map<String, Any>,
    ): Response<PaginatedResponseWrapper<WorkflowOverride>>

    @GET("$ENDPOINT/workflows/{workflowId}/tenants/{tenantId}")
    suspend fun getWorkflowOverride(
        @Path("workflowId") workflowId: String,
        @Path("tenantId") tenantId: String,
    ): Response<ResponseWrapper<WorkflowOverride>>

    @GET("$ENDPOINT/{overrideId}")
    suspend fun getWorkflowOverrideById(
        @Path("overrideId") overrideId: String,
    ): Response<ResponseWrapper<WorkflowOverride>>

    @PUT("$ENDPOINT/{overrideId}")
    suspend fun updateWorkflowOverrideById(
        @Path("overrideId") overrideId: String,
        @Body request: UpdateWorkflowOverrideRequest,
    ): Response<ResponseWrapper<WorkflowOverride>>

    @PUT("$ENDPOINT/workflows/{workflowId}/tenants/{tenantId}")
    suspend fun updateWorkflowOverride(
        @Path("workflowId") workflowId: String,
        @Path("tenantId") tenantId: String,
        @Body request: UpdateWorkflowOverrideRequest,
    ): Response<ResponseWrapper<WorkflowOverride>>

    @DELETE("$ENDPOINT/{overrideId}")
    suspend fun deleteWorkflowOverride(
        @Path("overrideId") overrideId: String,
    ): Response<ResponseWrapper<Boolean>>
}
