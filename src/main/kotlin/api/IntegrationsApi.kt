package co.novu.api

import co.novu.dto.request.integrations.IntegrationRequest
import co.novu.dto.response.integrations.IntegrationReponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IntegrationsApi {
    @GET("integrations")
    suspend fun getIntegrations(): Response<List<IntegrationReponse>>

    @POST("integrations")
    suspend fun createIntegration(@Body request: IntegrationRequest): Response<IntegrationReponse>

    @GET("integrations/active")
    suspend fun getActiveIntegrations(): Response<List<IntegrationReponse>>

    @GET("integrations/webhook/provider/{providerId}/status")
    suspend fun getProviderWebhook(@Path("providerId") providerId: String): Response<Any>

    @PUT("integrations/{integrationId}")
    suspend fun updateIntegrations(@Path("integrationId") integrationId: String, @Body request: IntegrationRequest): Response<IntegrationReponse>

    @DELETE("integrations/{integrationId}")
    suspend fun deleteIntegrations(@Path("integrationId") integrationId: String): Response<IntegrationReponse>
}
