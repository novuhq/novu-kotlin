package co.novu.api

import co.novu.dto.request.BroadcastEventRequest
import co.novu.dto.request.BulkTriggerEventRequest
import co.novu.dto.request.TriggerEventRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsApi {

    companion object {
        const val ENDPOINT = "events"
    }

    @POST("$ENDPOINT/trigger")
    suspend fun triggerEvent(@Body body: TriggerEventRequest): Response<ResponseWrapper<TriggerResponse>>

    @POST("$ENDPOINT/trigger/bulk")
    suspend fun bulkTriggerEvent(@Body body: BulkTriggerEventRequest): Response<ResponseWrapper<List<TriggerResponse>>>

    @POST("$ENDPOINT/trigger/broadcast")
    suspend fun broadcastEvent(@Body body: BroadcastEventRequest): Response<ResponseWrapper<TriggerResponse>>

    @DELETE("$ENDPOINT/trigger/{transactionId}")
    suspend fun cancelTriggerEvent(@Path("transactionId") transactionId: String): Response<ResponseWrapper<Boolean>>
}
