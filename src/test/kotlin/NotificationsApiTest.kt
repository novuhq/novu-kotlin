
import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Notification
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.getNotification
import co.novu.extensions.getNotificationGraphStats
import co.novu.extensions.getNotifications
import co.novu.extensions.getNotificationsStats
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
        NovuConfig(backendUrl = mockWebServer.url("/"))
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

        val result = mockNovu.getNotificationsStats()
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
        val result = mockNovu.getNotificationGraphStats()
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
        val result = mockNovu.getNotifications(channels, template, emails, "search")
        val request = mockWebServer.takeRequest()
        var sb = StringBuilder()
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
    fun testGetNotification() = runTest {
        val responseBody = ResponseWrapper(
            Notification()
        )

        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(responseBody)).setResponseCode(200))

        val notificationId = UUID.randomUUID().toString()
        val result = mockNovu.getNotification(notificationId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/notifications/$notificationId")
        assert(request.method == "GET")
        assert(result == responseBody)
    }
}
