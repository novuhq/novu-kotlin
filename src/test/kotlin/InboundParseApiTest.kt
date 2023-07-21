import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.ValidateMxRecordSetupForInboundParseResponse
import co.novu.extentions.validateMxRecordSetupForInboundParse
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class InboundParseApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testValidateMxRecordSetupForInboundParse() = runTest {
        val responseBody = ValidateMxRecordSetupForInboundParseResponse(
            mxRecordConfigured = true
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.validateMxRecordSetupForInboundParse()
        val request = mockWebServer.takeRequest()

        assert(request.path == "/inbound-parse/mx/status")
        assert(request.method == "GET")
        assert(result == responseBody)
    }
}
