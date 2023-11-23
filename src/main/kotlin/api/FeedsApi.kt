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

    companion object {
        const val ENDPOINT = "feeds"
    }

    @POST(ENDPOINT)
    suspend fun createFeed(@Body body: CreateByNameRequest): Response<ResponseWrapper<FeedResponse>>

    @GET(ENDPOINT)
    suspend fun getFeeds(): Response<ResponseWrapper<List<FeedResponse>>>

    @DELETE("$ENDPOINT/{feedId}")
    suspend fun deleteFeed(@Path("feedId") feedId: String): Response<ResponseWrapper<FeedResponse>>
}
