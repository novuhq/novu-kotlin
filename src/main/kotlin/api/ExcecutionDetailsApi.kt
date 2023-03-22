package co.novu.api

import co.novu.dto.response.PaginatedResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExcecutionDetailsApi {
    @GET("execution-details")
    suspend fun getExecutionDetails(
        @Query("notificationId") notificationId: String,
        @Query("subscriberId") subscriberId: String
    ): Response<PaginatedResponseWrapper<Any>>
}
