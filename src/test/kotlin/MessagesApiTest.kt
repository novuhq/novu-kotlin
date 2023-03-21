import co.novu.Novu
import co.novu.NovuConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.mockwebserver.MockWebServer


@OptIn(ExperimentalCoroutinesApi::class)
class MessagesApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/")),
    )

}