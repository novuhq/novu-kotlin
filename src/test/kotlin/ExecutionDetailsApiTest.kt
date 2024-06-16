import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.ExecutionDetails
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.executionDetails
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ExecutionDetailsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu =
        Novu(
            NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString()),
        )

    @Test
    fun testGetExecutionDetails() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    listOf(
                        ExecutionDetails(
                            id = "_id",
                            jobId = "_jobId",
                            status = "status",
                            detail = "detail",
                            isRetry = true,
                            isTest = true,
                            providerId = Any(),
                            raw = "raw",
                            source = "source",
                            transactionId = "transactionId",
                            createdAt = "createdAt",
                            organizationId = "_organizationId",
                            environmentId = "_environmentId",
                            notificationId = "_notificationId",
                            subscriberId = "_subscriberId",
                            notificationTemplateId = "_notificationTemplateId",
                            messageId = "_messageId",
                        ),
                    ),
                )
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody(Gson().toJson(responseBody)),
            )
            val notificationId = "notificationId"
            val subscriberId = "subscriberId"
            val result = mockNovu.executionDetails(notificationId, subscriberId)
            val request = mockWebServer.takeRequest()

            assert(request.method == "GET")
            assert(request.path == "/execution-details?notificationId=$notificationId&subscriberId=$subscriberId")
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }
}
