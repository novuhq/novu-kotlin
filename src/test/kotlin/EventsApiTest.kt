import co.novu.Novu
import co.novu.NovuConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class EventsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/")),
    )

    @Test
    fun testTriggerEvent() = runTest {
        TODO()
    }

    @Test
    fun testBulkTriggerEvent() = runTest {
        TODO()
    }

    @Test
    fun testBroadcastEvent() = runTest {
        TODO()
    }

    @Test
    fun testCancelTriggerEvent() = runTest {
        TODO()
    }
}
