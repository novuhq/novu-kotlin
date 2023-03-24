package co.novu.api

import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.FeedResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FeedsApi {

    @POST("feeds")
    suspend fun createFeed(@Body body: CreateByNameRequest): Response<ResponseWrapper<FeedResponse>>

    @GET("feeds")
    suspend fun getFeeds(): Response<ResponseWrapper<List<FeedResponse>>>

    @DELETE("feeds/{feedId}")
    suspend fun deleteFeed(@Path("feedId") feedId: String): Response<ResponseWrapper<FeedResponse>>
}
