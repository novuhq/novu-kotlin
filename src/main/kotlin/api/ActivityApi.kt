package co.novu.api

import co.novu.dto.response.PaginatedResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger

interface ActivityApi {

    @GET("activity")
    suspend fun getActivityFeed(
        @Query("channels") channels: List<String>?,
        @Query("templates") templates: List<String>?,
        @Query("emails") emails: List<String>?,
        @Query("page") page: BigInteger?,
        @Query("transactionId") transactionId: String,
    ): Response<Any> // changes
}
