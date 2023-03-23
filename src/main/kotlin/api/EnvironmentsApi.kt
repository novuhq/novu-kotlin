package co.novu.api

import co.novu.dto.ApiKeys
import co.novu.dto.Widget
import co.novu.dto.request.CreateEnvironmentRequest
import co.novu.dto.request.UpdateEnvironmentRequest
import co.novu.dto.response.GetEnvironmentResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EnvironmentsApi {

    @GET("environments/me")
    suspend fun getCurrentEnvironment(): Response<ResponseWrapper<GetEnvironmentResponse>>

    @POST("environments")
    suspend fun createEnvironment(@Body request: CreateEnvironmentRequest): Response<ResponseWrapper<GetEnvironmentResponse>>

    @GET("environments")
    suspend fun getEnvironments(): Response<ResponseWrapper<List<GetEnvironmentResponse>>>

    // checking
    @PUT("environments/{environmentId}")
    suspend fun updateEnvironment(@Path("environmentId") environmentId: String, @Body request: UpdateEnvironmentRequest): Response<Unit>

    @GET("environments/api-keys")
    suspend fun getApiKeys(): Response<ResponseWrapper<List<ApiKeys>>>

    @POST("environments/api-keys/regenerate")
    suspend fun regenerateApiKey(): Response<ResponseWrapper<List<ApiKeys>>>

    @PUT("environments/api-keys/widget/settings")
    suspend fun updateWidgetSettings(@Body request: Widget): Response<ResponseWrapper<GetEnvironmentResponse>>
}
