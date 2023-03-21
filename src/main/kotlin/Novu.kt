package co.novu

import co.novu.api.*
import co.novu.dto.request.events.BroadcastEventRequest
import co.novu.dto.request.events.TriggerEventRequest
import co.novu.helpers.RetrofitHelper
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

private val logger = KotlinLogging.logger {}

data class NovuConfig(var backendUrl: HttpUrl = "https://api.novu.co/v1/".toHttpUrlOrNull()!!)

class Novu(
    apiKey: String,
    config: NovuConfig = NovuConfig(),
) {
    private val retrofitInstance = RetrofitHelper(apiKey = apiKey, baseUrl = config.backendUrl).getInstance()

    private val eventsApi = retrofitInstance.create(EventsApi::class.java)

    internal val subscribersApi = retrofitInstance.create(SubscribersApi::class.java)

    internal val topicsApi = retrofitInstance.create(TopicsApi::class.java)

    internal val changesApi = retrofitInstance.create(ChangesApi::class.java)

    internal val integrationsApi = retrofitInstance.create(IntegrationsApi::class.java)

    internal val executionDetailsApi = retrofitInstance.create(ExcecutionDetailsApi::class.java)

    internal val feedsApi = retrofitInstance.create(FeedsApi::class.java)

    internal val messagesApi = retrofitInstance.create(MessagesApi::class.java)

    internal val notificationsApi = retrofitInstance.create(NotificationsApi::class.java)

    internal val environmentsApi = retrofitInstance.create(EnvironmentsApi::class.java)

    internal val layoutsApi = retrofitInstance.create(LayoutsApi::class.java)

    internal val notificationTemplatesApi = retrofitInstance.create(NotificationTemplatesApi::class.java)
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
    val novu = Novu(apiKey = "aeaf31aa1834b3a317dcf6970d028dae", NovuConfig())

    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")
}
