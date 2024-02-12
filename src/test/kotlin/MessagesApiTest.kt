import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Children
import co.novu.dto.ExecutionDetails
import co.novu.dto.Filters
import co.novu.dto.Job
import co.novu.dto.Step
import co.novu.dto.Subscriber
import co.novu.dto.Template
import co.novu.dto.Trigger
import co.novu.dto.Variables
import co.novu.dto.response.Message
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.TriggerResponse
import co.novu.extensions.deleteMessage
import co.novu.extensions.messages
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class MessagesApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetMessages() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                Message(
                    id = "123",
                    environmentId = "environmentId",
                    organizationId = "organizationId",
                    transactionId = "transactionId",
                    createdAt = "createdAt",
                    subscriber = Subscriber(
                        subscriberId = "subscriberId",
                        email = "email",
                        firstName = "firstName",
                        lastName = "lastName",
                        phone = "phone",
                        avatar = "avatar"
                    ),
                    template = Template(
                        id = "templateId",
                        name = "name",
                        triggers = listOf(
                            Trigger(
                                type = "type",
                                identifier = "identifier",
                                variables = listOf(
                                    Variables(
                                        name = "name"
                                    )
                                ),
                                subscriberVariables = listOf(
                                    Variables(
                                        name = "name"
                                    )
                                )
                            )
                        )

                    ),
                    jobs = listOf(
                        Job(
                            id = "jobId",
                            type = "type",
                            digest = "digest",
                            executionDetails = listOf(
                                ExecutionDetails(
                                    id = "executionDetailsId",
                                    status = "status",
                                    jobId = "jobId",
                                    detail = "detail",
                                    isRetry = true,
                                    isTest = true,
                                    providerId = "providerId",
                                    raw = "raw",
                                    source = "source"
                                )
                            ),
                            step = Step(
                                id = "stepId",
                                active = true,
                                filters = listOf(
                                    Filters(
                                        isNegated = true,
                                        type = "true",
                                        value = "value",
                                        children = listOf(
                                            Children(
                                                field = "field",
                                                operator = "operator",
                                                value = "value",
                                                on = "on"
                                            )
                                        )
                                    )
                                ),
                                template = "template"
                            ),
                            payload = "payload",
                            status = "status",
                            providerId = "providerId"
                        )
                    )
                )
            ),
            totalCount = BigInteger.TEN
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val channel = "channel"
        val subscriberId = "subscriberId"
        val transactionId = "transactionId"
        val limit = BigInteger.TEN
        val page = BigInteger.ONE
        val result = mockNovu.messages(channel, subscriberId, limit, page, transactionId)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/messages?channel=$channel&subscriberId=$subscriberId&limit=$limit&page=$page&transactionId=$transactionId")
        assert(request.method == "GET")
        assert(Gson().toJson(result) == Gson().toJson(responseBody))
    }

    @Test
    fun testDeleteMessage() = runTest {
        val responseBody = ResponseWrapper(
            TriggerResponse(
                acknowledged = true,
                status = "status"
            )
        )
        val messageId = "messageId"
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.deleteMessage(messageId)
        val request = mockWebServer.takeRequest()
        assert(request.path == "/messages/$messageId")
        assert(request.method == "DELETE")
        assert(result == responseBody)
    }
}
