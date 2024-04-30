import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Tenant
import co.novu.dto.Topic
import co.novu.dto.request.BroadcastEventRequest
import co.novu.dto.request.BulkTriggerEventRequest
import co.novu.dto.request.SubscriberRequest
import co.novu.dto.request.TriggerEventRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import co.novu.extensions.broadcast
import co.novu.extensions.bulkTrigger
import co.novu.extensions.cancelTriggerEvent
import co.novu.extensions.trigger
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
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
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
            transactionId = "transactionId",
            actor = mapOf(
                "subscriberId" to "sId",
                "email" to "email@mail.com",
                "firstName" to "fName",
                "lastName" to "lName",
                "phone" to "phoneNo"
            )
        )
        val result = mockNovu.trigger(requestBody)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(JsonParser().parse(request.body.readUtf8()).toString() == Gson().toJson(requestBody).toString())
        assert(request.method == "POST")
        assert(request.path == "/events/trigger")
    }

    @Test
    fun testTriggerEventToTopic() = runTest {
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
            to = listOf(
                Topic(
                    type = "Topic",
                    topicKey = "posts:comment:12345"
                )
            ),
            payload = mapOf("customVariables" to "Hello"),
            transactionId = "transactionId",
            tenant = Tenant(
                identifier = "identifier",
                name = "name",
                data = Any()
            )
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
            listOf(
                TriggerResponse(
                    acknowledged = true,
                    status = "status",
                    transactionId = "transactionId",
                    error = listOf("error")
                )
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
        val body = BulkTriggerEventRequest(requestBody)
        val result = mockNovu.bulkTrigger(body)
        val request = mockWebServer.takeRequest()
        assert(result == responseBody)
        assert(JsonParser().parse(request.body.readUtf8()).toString() == Gson().toJson(body).toString())
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
