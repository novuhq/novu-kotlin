import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.NotificationGroupsResponse
import co.novu.extensions.createNotificationGroup
import co.novu.extensions.deleteMessage
import co.novu.extensions.getNotificationGroups
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
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testGetNotificationGroups() = runTest {
        val responseBody = NotificationGroupsResponse(
            _id = "1234",
            name = "test",
            _environmentId = "environmentId",
            _organizationId = "organizationId",
            _parentId = "parentId"
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val response = mockNovu.getNotificationGroups()
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/notification-groups")
        assert(response == responseBody)
    }

    @Test
    fun testCreateNotificationGroup() = runTest {
        val responseBody = NotificationGroupsResponse(
            _id = "1234",
            name = "test",
            _environmentId = "environmentId",
            _organizationId = "organizationId",
            _parentId = "parentId"
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = CreateByNameRequest(name = "test")
        val response = mockNovu.createNotificationGroup(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/notification-groups")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(response == responseBody)
    }

}
