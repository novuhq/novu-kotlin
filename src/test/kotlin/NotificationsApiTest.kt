
import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Notification
import co.novu.dto.request.NotificationRequest
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.notification
import co.novu.extensions.notificationGraphStats
import co.novu.extensions.notifications
import co.novu.extensions.notificationsStats
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.StringBuilder
import java.math.BigInteger
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("").toString())
    )

    @Test
    @DisplayName("Get Notification Stats")
    fun testGetNotificationStats() = runTest {
        val responseBody = ResponseWrapper(
            NotificationStatsResponse(
                BigInteger.ONE,
                BigInteger.ONE,
                BigInteger.ONE
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setBody(Gson().toJson(responseBody))
                .setResponseCode(200)
        )

        val result = mockNovu.notificationsStats()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications/stats")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotificationGraphStats() = runTest {
        val responseBody = ResponseWrapper(
            data = listOf(
                NotificationGraphStatsResponse(
                    _id = UUID.randomUUID().toString(),
                    count = BigInteger.TEN,
                    templates = listOf("email"),
                    channels = emptyList()
                )
            )
        )
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(responseBody))
        mockWebServer.enqueue(response)
        val result = mockNovu.notificationGraphStats()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications/graph/stats")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotifications() = runTest {
        val responseBody = PaginatedResponseWrapper<Notification>(
            data = emptyList(),
            page = BigInteger.ONE,
            pageSize = BigInteger.TEN,
            totalCount = BigInteger.TEN
        )
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(responseBody))

        mockWebServer.enqueue(response)
        val channels = listOf("channel")
        val template = listOf("template")
        val emails = listOf("emails")
        val search = "search"
        val result = mockNovu.notifications(channels, template, emails, "search")
        val request = mockWebServer.takeRequest()
        val sb = StringBuilder()
        sb.append("?")
        channels.forEach { sb.append("channels=").append(it).append("&") }
        template.forEach { sb.append("templates=").append(it).append("&") }
        emails.forEach { sb.append("emails=").append(it).append("&") }
        sb.append("search=").append(search)
        assert(request.path == "/notifications$sb")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotificationsWithNotificationRequest() = runTest {
        val responseBody = PaginatedResponseWrapper<Notification>(
            data = emptyList(),
            page = BigInteger.ONE,
            pageSize = BigInteger.TEN,
            totalCount = BigInteger.TEN
        )
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(responseBody))

        mockWebServer.enqueue(response)
        val channels = listOf("channel")
        val template = listOf("template")
        val emails = listOf("emails")
        val search = "search"
        val page = BigInteger.ONE
        val transactionId = "transactionId"
        val notificationRequest = NotificationRequest(
            channels = channels,
            templates = template,
            emails = emails,
            search = search,
            page = page,
            transactionId = transactionId
        )

        val result = mockNovu.notifications(notificationRequest)
        val request = mockWebServer.takeRequest()

        val sb = StringBuilder("?")
        channels.forEach { sb.append("channels=").append(it).append("&") }
        template.forEach { sb.append("templates=").append(it).append("&") }
        emails.forEach { sb.append("emails=").append(it).append("&") }
        sb.append("search=").append(search).append("&")
        sb.append("page=").append(page).append("&")
        sb.append("transactionId=").append(transactionId)
        assert(request.path == "/notifications$sb")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotification() = runTest {
        val responseBody = ResponseWrapper(
            Notification()
        )

        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(responseBody)).setResponseCode(200))

        val notificationId = UUID.randomUUID().toString()
        val result = mockNovu.notification(notificationId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/notifications/$notificationId")
        assert(request.method == "GET")
        assert(result == responseBody)
    }
}
