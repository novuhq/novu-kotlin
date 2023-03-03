package co.novu.api

import co.novu.dto.request.topics.CreateTopicRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.SubscriberList
import co.novu.dto.response.topics.TopicResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface TopicsApi {

    @GET("topics")
    suspend fun getTopics(@Query("page") page: BigInteger, @Query("pageSize")pageSize: BigInteger, @Query("key") key: String): Response<PaginatedResponseWrapper<TopicResponse>>

    @POST("topics")
    suspend fun createTopic(@Body request: CreateTopicRequest): Response<Any>

    @POST("topics/{topicKey}/subscribers")
    suspend fun addSubscriber(@Path("topicKey") topicKey: String): Response<List<SubscriberList>>

    @POST("topics/{topicKey}/subscribers/removal")
    suspend fun removeSubscriber(@Path("topicKey") topicKey: String): Response<List<SubscriberList>>

    @GET("topics/{topicKey}")
    suspend fun getTopic(@Query("topicKey") topicKey: String): Response<TopicResponse>

    @PATCH("topics/{topicKey}")
    suspend fun renameTopic(@Path("topicKey") topicKey: String): Response<TopicResponse>
}
