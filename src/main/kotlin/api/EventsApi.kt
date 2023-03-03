package co.novu.api

import co.novu.dto.request.events.BroadcastEventRequest
import co.novu.dto.request.events.TriggerEventRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.events.TriggerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsApi {

    @POST("events/trigger")
    suspend fun triggerEvent(@Body body: TriggerEventRequest): Response<ResponseWrapper<TriggerResponse>>

    @POST("events/trigger/bulk")
    suspend fun bulkTriggerEvent(@Body body: List<TriggerEventRequest>): Response<ResponseWrapper<List<TriggerResponse>>>

    @POST("events/trigger/broadcast")
    suspend fun broadcastEvent(@Body body: BroadcastEventRequest): Response<ResponseWrapper<TriggerResponse>>

    @DELETE("events/trigger/{transactionId}")
    suspend fun cancelTriggerEvent(@Path("transactionId") transactionId: String): Response<ResponseWrapper<Boolean>>
}
