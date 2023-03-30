package co.novu.api

import co.novu.dto.response.Message
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.math.BigInteger

interface MessagesApi {
    @GET("messages")
    suspend fun getMessages(
        @Query("channel") channel: String? = null,
        @Query("subscriberId") subscriberId: String? = null,
        @Query("limit") limit: BigInteger? = null,
        @Query("page") page: BigInteger? = null
    ): Response<PaginatedResponseWrapper<Message>>

    @DELETE("messages/{messageId}")
    suspend fun deleteMessage(@Path("messageId") messageId: String): Response<ResponseWrapper<TriggerResponse>>
}
