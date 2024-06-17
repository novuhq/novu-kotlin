package co.novu.api

import co.novu.dto.request.CreateLayoutRequest
import co.novu.dto.response.CreateLayoutResponse
import co.novu.dto.response.GetLayoutsResponse
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
import java.math.BigInteger

interface LayoutsApi {
    companion object {
        const val ENDPOINT = "layouts"
    }

    @POST(ENDPOINT)
    suspend fun createLayout(
        @Body request: CreateLayoutRequest,
    ): Response<ResponseWrapper<CreateLayoutResponse>>

    @GET(ENDPOINT)
    suspend fun filterLayouts(
        @Query("page") page: BigInteger,
        @Query("pageSize") pageSize: BigInteger,
        @Query("sortBy") sortBy: String,
        @Query("orderBy") orderBy: BigInteger,
    ): Response<PaginatedResponseWrapper<GetLayoutsResponse>>

    @GET("$ENDPOINT/{layoutId}")
    suspend fun getLayout(
        @Path("layoutId") layoutId: String,
    ): Response<ResponseWrapper<GetLayoutsResponse>>

    @DELETE("$ENDPOINT/{layoutId}")
    suspend fun deleteLayout(
        @Path("layoutId") layoutId: String,
    ): Response<Unit>

    @PATCH("$ENDPOINT/{layoutId}")
    suspend fun updateLayout(
        @Path("layoutId") layoutId: String,
        @Body request: CreateLayoutRequest,
    ): Response<ResponseWrapper<GetLayoutsResponse>>

    @POST("$ENDPOINT/{layoutId}/default")
    suspend fun setDefaultLayout(
        @Path("layoutId") layoutId: String,
    ): Response<Unit>
}
