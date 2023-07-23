import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.DeleteWorkflowGroupResponse
import co.novu.dto.response.NotificationGroupsResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.createWorkflowGroup
import co.novu.extensions.deleteWorkflowGroup
import co.novu.extensions.getWorkflowGroup
import co.novu.extensions.getWorkflowGroups
import co.novu.extensions.updateWorkflowGroup
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationGroupsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetNotificationGroups() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                NotificationGroupsResponse(
                    _id = "1234",
                    name = "test",
                    _environmentId = "environmentId",
                    _organizationId = "organizationId",
                    _parentId = "parentId"
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val response = mockNovu.getWorkflowGroups()
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/notification-groups")
        assert(response == responseBody)
    }

    @Test
    fun testCreateNotificationGroup() = runTest {
        val responseBody = ResponseWrapper(
            NotificationGroupsResponse(
                _id = "1234",
                name = "test",
                _environmentId = "environmentId",
                _organizationId = "organizationId",
                _parentId = "parentId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = CreateByNameRequest(name = "test")
        val response = mockNovu.createWorkflowGroup(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/notification-groups")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(response == responseBody)
    }

    @Test
    fun testGetWorkflowGroup() = runTest {
        val responseBody = ResponseWrapper(
            NotificationGroupsResponse(
                _id = "1234",
                name = "test",
                _environmentId = "environmentId",
                _organizationId = "organizationId",
                _parentId = "parentId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val id = "id"
        val response = mockNovu.getWorkflowGroup(id)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/notification-groups/$id")
        assert(response == responseBody)
    }

    @Test
    fun testUpdateWorkflowGroup() = runTest {
        val responseBody = ResponseWrapper(
            NotificationGroupsResponse(
                _id = "1234",
                name = "test",
                _environmentId = "environmentId",
                _organizationId = "organizationId",
                _parentId = "parentId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val id = "id"
        val requestBody = CreateByNameRequest(name = "test")
        val response = mockNovu.updateWorkflowGroup(id, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PATCH")
        assert(request.path == "/notification-groups/$id")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(response == responseBody)
    }

    @Test
    fun testDeleteWorkflowGroup() = runTest {
        val responseBody = ResponseWrapper(
            DeleteWorkflowGroupResponse(
                acknowledged = true
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val id = "id"
        val response = mockNovu.deleteWorkflowGroup(id)
        val request = mockWebServer.takeRequest()

        assert(request.method == "DELETE")
        assert(request.path == "/notification-groups/$id")
        assert(response == responseBody)
    }
}
