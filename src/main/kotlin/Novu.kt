package co.novu

import co.novu.api.ChangesApi
import co.novu.api.EnvironmentsApi
import co.novu.api.EventsApi
import co.novu.api.ExecutionDetailsApi
import co.novu.api.FeedsApi
import co.novu.api.InboundParseApi
import co.novu.api.IntegrationsApi
import co.novu.api.LayoutsApi
import co.novu.api.MessagesApi
import co.novu.api.NotificationGroupsApi
import co.novu.api.NotificationTemplatesApi
import co.novu.api.NotificationsApi
import co.novu.api.SubscribersApi
import co.novu.api.TopicsApi
import co.novu.dto.request.BroadcastEventRequest
import co.novu.dto.request.TriggerEventRequest
import co.novu.extensions.changes
import co.novu.helpers.RetrofitHelper
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import okhttp3.internal.concurrent.TaskRunner.Companion.logger

data class NovuConfig(var backendUrl: String? = "https://api.novu.co/v1/")

class Novu(
    apiKey: String,
    config: NovuConfig? = NovuConfig()
) {

    private val logger = KotlinLogging.logger {}

    private val retrofitInstance = RetrofitHelper(apiKey = apiKey, baseUrl = config?.backendUrl!!).getInstance()

    private val eventsApi = retrofitInstance.create(EventsApi::class.java)

    internal val subscribersApi = retrofitInstance.create(SubscribersApi::class.java)

    internal val topicsApi = retrofitInstance.create(TopicsApi::class.java)

    internal val changesApi = retrofitInstance.create(ChangesApi::class.java)

    internal val integrationsApi = retrofitInstance.create(IntegrationsApi::class.java)

    internal val executionDetailsApi = retrofitInstance.create(ExecutionDetailsApi::class.java)

    internal val feedsApi = retrofitInstance.create(FeedsApi::class.java)

    internal val messagesApi = retrofitInstance.create(MessagesApi::class.java)

    internal val notificationsApi = retrofitInstance.create(NotificationsApi::class.java)

    internal val environmentsApi = retrofitInstance.create(EnvironmentsApi::class.java)

    internal val layoutsApi = retrofitInstance.create(LayoutsApi::class.java)

    internal val notificationTemplatesApi = retrofitInstance.create(NotificationTemplatesApi::class.java)

    internal val notificationGroupsApi = retrofitInstance.create(NotificationGroupsApi::class.java)

    internal val inboundParseApi = retrofitInstance.create(InboundParseApi::class.java)
    fun trigger(body: TriggerEventRequest) = runBlocking {
        val response = eventsApi.triggerEvent(body)
        if (response.isSuccessful) {
            response.body().apply { logger.info { this } }
        } else {
            response.errorBody()?.string().apply { logger.error { this } }
        }
    }

    fun bulkTrigger(body: List<TriggerEventRequest>) = runBlocking {
        val response = eventsApi.bulkTriggerEvent(body)
        if (response.isSuccessful) {
            response.body().apply { logger.info { this } }
        } else {
            response.errorBody()?.string().apply { logger.error { this } }
        }
    }

    fun broadcast(body: BroadcastEventRequest) = runBlocking {
        val response = eventsApi.broadcastEvent(body)
        if (response.isSuccessful) {
            response.body().apply { logger.info { this } }
        } else {
            response.errorBody()?.string().apply { logger.error { this } }
        }
    }

    fun cancelTriggerEvent(transactionId: String) = runBlocking {
        val response = eventsApi.cancelTriggerEvent(transactionId)
        if (response.isSuccessful) {
            response.body().apply { logger.info { this } }
        } else {
            response.errorBody()?.string().apply { logger.error { this } }
        }
    }
}

fun main() {
    println(System.getenv("NOVU_API_KEY"))
    val novu = Novu(apiKey = "af3749ea80b67bf2c4f267084b197f98")
    val changes = novu.changes()
}
