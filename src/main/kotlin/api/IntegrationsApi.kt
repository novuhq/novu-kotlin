package co.novu.api

import co.novu.dto.request.IntegrationRequest
import co.novu.dto.response.IntegrationResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IntegrationsApi {
    companion object {
        const val ENDPOINT = "integrations"
    }

    @GET(ENDPOINT)
    suspend fun getIntegrations(): Response<ResponseWrapper<List<IntegrationResponse>>>

    @POST(ENDPOINT)
    suspend fun createIntegration(
        @Body request: IntegrationRequest,
    ): Response<ResponseWrapper<IntegrationResponse>>

    @GET("$ENDPOINT/active")
    suspend fun getActiveIntegrations(): Response<ResponseWrapper<List<IntegrationResponse>>>

    @GET("$ENDPOINT/webhook/provider/{providerId}/status")
    suspend fun getProviderWebhook(
        @Path("providerId") providerId: String,
    ): Response<ResponseWrapper<Boolean>>

    @PUT("$ENDPOINT/{integrationId}")
    suspend fun updateIntegration(
        @Path("integrationId") integrationId: String,
        @Body request: IntegrationRequest,
    ): Response<ResponseWrapper<IntegrationResponse>>

    @DELETE("$ENDPOINT/{integrationId}")
    suspend fun deleteIntegration(
        @Path("integrationId") integrationId: String,
    ): Response<ResponseWrapper<List<IntegrationResponse>>>

    @POST("$ENDPOINT/{integrationId}/set-primary")
    suspend fun setPrimaryIntegration(
        @Path("integrationId") integrationId: String,
    ): Response<ResponseWrapper<IntegrationResponse>>
}
