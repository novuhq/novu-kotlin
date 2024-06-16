import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.PreferenceSettings
import co.novu.dto.request.GetWorkflowOverrideRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.createWorkflowOverride
import co.novu.extensions.deleteWorkflowOverride
import co.novu.extensions.getWorkflowOverride
import co.novu.extensions.getWorkflowOverrideById
import co.novu.extensions.getWorkflowOverrides
import co.novu.extensions.updateWorkflowOverride
import co.novu.extensions.updateWorkflowOverrideById
import com.google.gson.Gson
import dto.request.CreateWorkflowOverrideRequest
import dto.workflowoverrides.UpdateWorkflowOverrideRequest
import dto.workflowoverrides.WorkflowOverride
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WorkflowOverrideApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu =
        Novu(
            NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString()),
        )

    @Test
    fun testCreateWorkflowOverride() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    WorkflowOverride(
                        id = "id",
                        tenantId = "tId",
                        workflowId = "wId",
                        active = true,
                        preferenceSettings =
                            PreferenceSettings(
                                email = true,
                                sms = true,
                                push = true,
                                inApp = true,
                                chat = true,
                            ),
                    ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
            val requestBody =
                CreateWorkflowOverrideRequest(
                    workflowId = "wId",
                    tenantId = "tId",
                )
            requestBody.active = true
            requestBody.preferenceSettings =
                PreferenceSettings(
                    email = true,
                    sms = true,
                    push = true,
                    inApp = true,
                    chat = true,
                )
            val result = mockNovu.createWorkflowOverride(requestBody)
            val request = mockWebServer.takeRequest()

            assert(request.method == "POST")
            assert(request.path == "/workflow-overrides")
            assert(request.body.readUtf8() == Gson().toJson(requestBody))
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testGetWorkflowOverrides() =
        runTest {
            val responseBody =
                PaginatedResponseWrapper(
                    data =
                        listOf(
                            WorkflowOverride(
                                id = "id",
                                tenantId = "tId",
                                workflowId = "wId",
                                active = true,
                                preferenceSettings =
                                    PreferenceSettings(
                                        email = true,
                                        sms = true,
                                        push = true,
                                        inApp = true,
                                        chat = true,
                                    ),
                            ),
                        ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
            val requestBody =
                GetWorkflowOverrideRequest(
                    page = 1,
                    limit = 10,
                )
            val result = mockNovu.getWorkflowOverrides(requestBody)
            val request = mockWebServer.takeRequest()

            assert(request.method == "GET")
            assert(request.path == "/workflow-overrides?limit=${requestBody.limit}&page=${requestBody.page}")
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testGetWorkflowOverride() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    WorkflowOverride(
                        id = "id",
                        tenantId = "tId",
                        workflowId = "wId",
                        active = true,
                        preferenceSettings =
                            PreferenceSettings(
                                email = true,
                                sms = true,
                                push = true,
                                inApp = true,
                                chat = true,
                            ),
                    ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

            val workflowId = "wId"
            val tenantId = "tId"
            val result = mockNovu.getWorkflowOverride(workflowId, tenantId)
            val request = mockWebServer.takeRequest()

            assert(request.method == "GET")
            assert(request.path == "/workflow-overrides/workflows/$workflowId/tenants/$tenantId")
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testGetWorkflowOverrideById() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    WorkflowOverride(
                        id = "id",
                        tenantId = "tId",
                        workflowId = "wId",
                        active = true,
                        preferenceSettings =
                            PreferenceSettings(
                                email = true,
                                sms = true,
                                push = true,
                                inApp = true,
                                chat = true,
                            ),
                    ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

            val overrideId = "oId"
            val result = mockNovu.getWorkflowOverrideById(overrideId)
            val request = mockWebServer.takeRequest()

            assert(request.method == "GET")
            assert(request.path == "/workflow-overrides/$overrideId")
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testUpdateWorkflowOverrideById() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    WorkflowOverride(
                        id = "id",
                        tenantId = "tId",
                        workflowId = "wId",
                        active = true,
                        preferenceSettings =
                            PreferenceSettings(
                                email = true,
                                sms = true,
                                push = true,
                                inApp = true,
                                chat = true,
                            ),
                    ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

            val requestBody =
                UpdateWorkflowOverrideRequest(
                    active = true,
                    preferenceSettings =
                        PreferenceSettings(
                            email = true,
                            sms = true,
                            push = true,
                            inApp = true,
                            chat = true,
                        ),
                )

            val overrideId = "oId"
            val result = mockNovu.updateWorkflowOverrideById(overrideId, requestBody)
            val request = mockWebServer.takeRequest()

            assert(request.method == "PUT")
            assert(request.path == "/workflow-overrides/$overrideId")
            assert(request.body.readUtf8() == Gson().toJson(requestBody))
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testUpdateWorkflowOverride() =
        runTest {
            val responseBody =
                ResponseWrapper(
                    WorkflowOverride(
                        id = "id",
                        tenantId = "tId",
                        workflowId = "wId",
                        active = true,
                        preferenceSettings =
                            PreferenceSettings(
                                email = true,
                                sms = true,
                                push = true,
                                inApp = true,
                                chat = true,
                            ),
                    ),
                )

            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

            val workflowId = "wId"
            val tenantId = "tId"
            val requestBody =
                UpdateWorkflowOverrideRequest(
                    active = true,
                    preferenceSettings =
                        PreferenceSettings(
                            email = true,
                            sms = true,
                            push = true,
                            inApp = true,
                            chat = true,
                        ),
                )

            val result = mockNovu.updateWorkflowOverride(workflowId, tenantId, requestBody)
            val request = mockWebServer.takeRequest()

            assert(request.method == "PUT")
            assert(request.path == "/workflow-overrides/workflows/$workflowId/tenants/$tenantId")
            assert(request.body.readUtf8() == Gson().toJson(requestBody))
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }

    @Test
    fun testDeleteWorkflow() =
        runTest {
            val responseBody = ResponseWrapper(true)
            mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))

            val overrideId = "oId"
            val result = mockNovu.deleteWorkflowOverride(overrideId)
            val request = mockWebServer.takeRequest()

            assert(request.method == "DELETE")
            assert(request.path == "/workflow-overrides/$overrideId")
            assert(Gson().toJson(responseBody) == Gson().toJson(result))
        }
}
