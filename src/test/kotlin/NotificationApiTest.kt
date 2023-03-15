
import co.novu.api.NotificationsApi
import co.novu.dto.response.NotificationGraphStatsResponse
import co.novu.dto.response.NotificationStatsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.helpers.RetrofitHelper
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNotificationsApi = RetrofitHelper(apiKey = "1234", baseUrl = mockWebServer.url("/")).getInstance().create(NotificationsApi::class.java)

    @AfterEach
    fun shutdown() {
        mockWebServer.shutdown()
    }

    @Test
    @DisplayName("Get Notification Stats")
    fun testGetNotificationStats() = runTest {
        mockWebServer.enqueue(
            MockResponse().setBody(
                Gson().toJson(
                    NotificationStatsResponse(
                        BigInteger.ONE,
                        BigInteger.ONE,
                        BigInteger.ONE,
                    ),
                ),
            ).setResponseCode(200),
        )

        val result = mockNotificationsApi.getNotificationsStats()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications/stats")
        assert(request.method == "GET")
        assert(result.code() == 200)
        assert(result.errorBody() == null)
        assert(result.body() != null)
    }

    @Test
    fun testGetNotificationGraphStats() = runTest {
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(
                Gson().toJson(
                    PaginatedResponseWrapper<NotificationGraphStatsResponse>(
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
                    ),
                ),
            )
        mockWebServer.enqueue(response)
        val result = mockNotificationsApi.getNotificationGraphStats()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/notifications/graph/stats")
        assert(request.method == "GET")
        assert(result.code() == 200)
        assert(result.errorBody() == null)
        assert(result.body() != null)
    }
}
