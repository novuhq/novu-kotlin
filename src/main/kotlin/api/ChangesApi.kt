package co.novu.api

import co.novu.dto.response.ChangesResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

public interface ChangesApi {

    @GET("changes")
    suspend fun getChanges(@Query("page") page: BigInteger? = null, @Query("limit") limit: BigInteger? = null, @Query("promoted") promoted: String? = null): Response<PaginatedResponseWrapper<ChangesResponse>>

    @GET("changes/count")
    suspend fun getChangesCount(): Response<ResponseWrapper<BigInteger>>

    @POST("changes/bulk/apply")
    suspend fun applyBulkChanges(): Response<ResponseWrapper<List<ChangesResponse>>>

    @POST("changes/{changedId}/apply")
    suspend fun applyChange(@Path("changedId") changedId: String): Response<ResponseWrapper<List<ChangesResponse>>>
}
