package co.novu.api

import co.novu.dto.response.FeedResponse
import co.novu.dto.response.PaginatedResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FeedsApi {

    @POST("feeds")
    suspend fun createFeed(@Body name: String): Response<FeedResponse>

    @GET("feeds")
    suspend fun getFeeds(): Response<PaginatedResponseWrapper<FeedResponse>>

    @DELETE("feeds/{feedId}")
    suspend fun deleteFeed(@Path("feedId") feedId: String): Response<PaginatedResponseWrapper<FeedResponse>>
}
