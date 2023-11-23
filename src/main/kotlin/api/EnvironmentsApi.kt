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

    companion object {
        const val ENDPOINT = "environments"
    }

    @GET("$ENDPOINT/me")
    suspend fun getCurrentEnvironment(): Response<ResponseWrapper<GetEnvironmentResponse>>

    @POST(ENDPOINT)
    suspend fun createEnvironment(@Body request: CreateEnvironmentRequest): Response<ResponseWrapper<GetEnvironmentResponse>>

    @GET(ENDPOINT)
    suspend fun getEnvironments(): Response<ResponseWrapper<List<GetEnvironmentResponse>>>

    @PUT("$ENDPOINT/{environmentId}")
    suspend fun updateEnvironment(@Path("environmentId") environmentId: String, @Body request: UpdateEnvironmentRequest): Response<ResponseWrapper<GetEnvironmentResponse>>

    @GET("$ENDPOINT/api-keys")
    suspend fun getApiKeys(): Response<ResponseWrapper<List<ApiKeys>>>

    @POST("$ENDPOINT/api-keys/regenerate")
    suspend fun regenerateApiKey(): Response<ResponseWrapper<List<ApiKeys>>>

    @PUT("$ENDPOINT/api-keys/widget/settings")
    suspend fun updateWidgetSettings(@Body request: Widget): Response<ResponseWrapper<GetEnvironmentResponse>>
}
