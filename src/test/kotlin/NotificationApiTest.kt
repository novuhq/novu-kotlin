
import co.novu.api.NotificationsApi
import co.novu.dto.response.NotificationStatsResponse
import co.novu.helpers.RetrofitHelper
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationApiTest {
    private val mockWebServer = MockWebServer()
    private val notificationsApi = RetrofitHelper(apiKey = "1234", baseUrl = mockWebServer.url("/")).getInstance().create(NotificationsApi::class.java)

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

        val response = notificationsApi.getNotificationsStats()
        val request = mockWebServer.takeRequest()
        response.body()
        assert(request.path == "/notifications/stats")
        assert(request.method == "GET")
        assert(response.code() == 200)
        assert(response.errorBody() == null)
        assert(response.body() != null)
        mockWebServer.shutdown()
    }
}
