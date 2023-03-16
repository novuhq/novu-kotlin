
import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
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
import java.math.BigInteger
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/")),
    )

    @Test
    @DisplayName("Get Notification Stats")
    fun testGetNotificationStats() = runTest {
        val responseBody = NotificationStatsResponse(
            BigInteger.ONE,
            BigInteger.ONE,
            BigInteger.ONE,
        )
        mockWebServer.enqueue(
            MockResponse()
                .setBody(Gson().toJson(responseBody))
                .setResponseCode(200),
        )

        val result = mockNovu.getNotificationsStats()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications/stats")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotificationGraphStats() = runTest {
        val responseBody = PaginatedResponseWrapper(
            page = BigInteger.ONE,
            data = listOf(
                NotificationGraphStatsResponse(
                    _id = UUID.randomUUID().toString(),
                    count = BigInteger.TEN,
                    templates = listOf("email"),
                    channels = emptyList(),
                ),
            ),
            totalCount = BigInteger.TEN,
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
        val responseBody = PaginatedResponseWrapper<Any>(
            data = emptyList(),
            page = BigInteger.ONE,
            pageSize = BigInteger.TEN,
            totalCount = BigInteger.TEN,
        )
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(responseBody))

        mockWebServer.enqueue(response)
        val result = mockNovu.getNotifications(emptyList(), emptyList(), emptyList(), "search")
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications")
        assert(request.method == "GET")
        assert(responseBody == result)
    }

    @Test
    fun testGetNotification() = runTest {
        TODO()
    }
}
