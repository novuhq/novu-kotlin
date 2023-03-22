import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.events.BroadcastEventRequest
import co.novu.dto.request.events.TriggerEventRequest
import co.novu.dto.request.subscribers.SubscriberRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.events.TriggerResponse
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class EventsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testTriggerEvent() = runTest {
        val responseBody = ResponseWrapper(
            TriggerResponse(
                acknowledged = true,
                status = "status",
                transactionId = "transactionId",
                error = listOf("error")
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )
        val requestBody = TriggerEventRequest(
            name = "test",
            to = SubscriberRequest(
                subscriberId = "subscriberId",
                email = "email@email.com",
                firstName = "John",
                lastName = "Doe"
            ),
            payload = mapOf("customVariables" to "Hello"),
            transactionId = "transactionId"
        )
        val result = mockNovu.trigger(requestBody)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(JsonParser().parse(request.body.readUtf8()).toString() == Gson().toJson(requestBody).toString())
        assert(request.method == "POST")
        assert(request.path == "/events/trigger")
    }

    @Test
    fun testBulkTriggerEvent() = runTest {
        val responseBody = ResponseWrapper(
            TriggerResponse(
                acknowledged = true,
                status = "status",
                transactionId = "transactionId",
                error = listOf("error")
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )
        val requestBody = listOf(
            TriggerEventRequest(
                name = "test",
                to = SubscriberRequest(
                    subscriberId = "subscriberId",
                    email = "email@email.com",
                    firstName = "John",
                    lastName = "Doe"
                ),
                payload = mapOf("customVariables" to "Hello"),
                transactionId = "transactionId"
            )
        )
        val result = mockNovu.bulkTrigger(requestBody)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(JsonParser().parse(request.body.readUtf8()).toString() == Gson().toJson(requestBody).toString())
        assert(request.method == "POST")
        assert(request.path == "/events/trigger/bulk")
    }

    @Test
    fun testBroadcastEvent() = runTest {
        val responseBody = ResponseWrapper(
            TriggerResponse(
                acknowledged = true,
                status = "status",
                transactionId = "transactionId",
                error = listOf("error")
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )
        val requestBody = BroadcastEventRequest(
            name = "test",
            payload = mapOf("customVariables" to "Hello"),
            transactionId = "transactionId"
        )
        val result = mockNovu.broadcast(requestBody)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(JsonParser().parse(request.body.readUtf8()).toString() == Gson().toJson(requestBody).toString())
        assert(request.method == "POST")
        assert(request.path == "/events/trigger/broadcast")
    }

    @Test
    fun testCancelTriggerEvent() = runTest {
        val responseBody = ResponseWrapper(true)
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )
        val transactionId = "transactionId"
        val result = mockNovu.cancelTriggerEvent(transactionId)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(request.method == "DELETE")
        assert(request.path == "/events/trigger/$transactionId")
    }
}
