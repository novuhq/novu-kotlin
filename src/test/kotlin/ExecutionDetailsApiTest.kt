import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.ExecutionDetails
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.getExecutionDetails
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class ExecutionDetailsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testGetExecutionDetails() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                ExecutionDetails(
                    _id = "_id",
                    _jobId = "_jobId",
                    status = "status",
                    detail = "detail",
                    isRetry = true,
                    isTest = true,
                    providerId = Any(),
                    raw = "raw",
                    source = "source",
                    transactionId = "transactionId",
                    createdAt = "createdAt",
                    _organizationId = "_organizationId",
                    _environmentId = "_environmentId",
                    _notificationId = "_notificationId",
                    _subscriberId = "_subscriberId",
                    _notificationTemplateId = "_notificationTemplateId",
                    _messageId = "_messageId"
                )
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val notificationId = "notificationId"
        val subscriberId = "subscriberId"
        val result = mockNovu.getExecutionDetails(notificationId, subscriberId)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/execution-details?notificationId=$notificationId&subscriberId=$subscriberId")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }
}
