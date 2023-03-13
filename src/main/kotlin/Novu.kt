package co.novu

import co.novu.api.ChangesApi
import co.novu.api.EventsApi
import co.novu.api.SubscribersApi
import co.novu.api.TopicsApi
import co.novu.dto.request.events.BroadcastEventRequest
import co.novu.dto.request.events.TriggerEventRequest
import co.novu.extensions.getSubscriber
import co.novu.helpers.RetrofitHelper
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import retrofit2.create

private val logger = KotlinLogging.logger {}

data class NovuConfig(var backendUrl: String = "https://api.novu.co/v1/")

class Novu(
    apiKey: String,
    config: NovuConfig = NovuConfig(),
) {

    private val eventsApi =
        RetrofitHelper(apiKey = apiKey, baseUrl = config.backendUrl).getInstance().create(EventsApi::class.java)

    internal val subscribersApi =
        RetrofitHelper(apiKey = apiKey, baseUrl = config.backendUrl).getInstance().create(SubscribersApi::class.java)

    internal val topicsApi =
        RetrofitHelper(apiKey = apiKey, baseUrl = config.backendUrl).getInstance().create(TopicsApi::class.java)

    internal val changesApi =
        RetrofitHelper(apiKey = apiKey, baseUrl = config.backendUrl).getInstance().create(ChangesApi::class.java)
    fun trigger(body: TriggerEventRequest) = runBlocking {
        eventsApi.triggerEvent(body)
            .body()
            .apply { logger.info { this } }
    }

    fun bulkTrigger(body: List<TriggerEventRequest>) = runBlocking {
        eventsApi.bulkTriggerEvent(body)
            .body()
            .apply { logger.info { this } }
    }

    fun broadcast(body: BroadcastEventRequest) = runBlocking {
        eventsApi.broadcastEvent(body)
            .body()
            .apply { logger.info { this } }
    }

    fun cancelTriggerEvent(transactionId: String) = runBlocking {
        eventsApi.cancelTriggerEvent(transactionId)
            .body()
            .apply { logger.info { this } }
    }
}
fun main(args: Array<String>) {
    println("Hello World!")

    val novu = Novu(apiKey = "aeaf31aa1834b3a317dcf6970d028dae")
    val response = novu.getSubscriber("")
    logger.info(response.toString())
    println("Program arguments: ${args.joinToString()}")
}
