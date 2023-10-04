package co.novu.api

import co.novu.dto.Tenant
import co.novu.dto.request.TenantRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TenantsApi {

    @GET("tenants")
    suspend fun getTenants(
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null
    ): Response<PaginatedResponseWrapper<Tenant>>

    @POST("tenants")
    suspend fun createTenant(@Body request: TenantRequest): Response<ResponseWrapper<Tenant>>

    @GET("tenants/{identifier}")
    suspend fun getTenant(@Path("identifier") identifier: String): Response<ResponseWrapper<Tenant>>

    @PATCH("tenants/{identifier}")
    suspend fun updateTenant(
        @Path("identifier") identifier: String,
        @Body request: TenantRequest
    ): Response<ResponseWrapper<Tenant>>

    @DELETE("tenants/{identifier}")
    suspend fun deleteTenant(@Path("identifier") identifier: String): Response<Unit>
}
