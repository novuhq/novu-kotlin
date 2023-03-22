package co.novu.api

import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.events.TriggerResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface MessagesApi {
    @GET("messages")
    suspend fun getMessages(
        @Query("channel") channel: String,
        @Query("subscriberId") subscriberId: String,
        @Query("limit") limit: BigInteger,
        @Query("page") page: BigInteger
    ): Response<PaginatedResponseWrapper<Any>>

    @DELETE("message/{messageId}")
    suspend fun deleteMessage(@Path("messageId") messageId: String): Response<TriggerResponse>
}
