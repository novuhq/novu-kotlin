package co.novu.api

import co.novu.dto.request.CreateFeedRequest
import co.novu.dto.response.GetFeedsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


 interface ExcecutionDetailsApi {
    @POST("feeds")
    suspend fun createFeed(@Body request: CreateFeedRequest): Response<ResponseWrapper<Any>>

    @GET("feeds")
    suspend fun getFeeds(): Response<PaginatedResponseWrapper<GetFeedsResponse>>

    @DELETE("feeds/{feedId}")
    suspend fun deleteFeed(@Path("feedId") feedId: String): Response<PaginatedResponseWrapper<GetFeedsResponse>>

}
