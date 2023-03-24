import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.response.FeedResponse
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.createFeed
import co.novu.extensions.deleteFeed
import co.novu.extensions.feeds
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FeedsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testCreateFeed() = runTest {
        val responseBody = ResponseWrapper(
            FeedResponse(
                _id = "123",
                name = "test",
                _environmentId = "enviromentId",
                _organizationId = "organizationId",
                identifier = "identifier",
                deleted = false,
                createdAt = "createdAt",
                updatedAt = "updatedAt"
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(201).setBody(Gson().toJson(responseBody)))
        val requestBody = CreateByNameRequest(
            name = "test"
        )
        val result = mockNovu.createFeed(requestBody)
        val request = mockWebServer.takeRequest()
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(request.path == "/feeds")
        assert(request.method == "POST")
        assert(result == responseBody)
    }

    @Test
    fun testGetFeeds() = runTest {
        val responseBody = ResponseWrapper(
            listOf(
                FeedResponse(
                    _id = "123",
                    name = "test",
                    _environmentId = "enviromentId",
                    _organizationId = "organizationId",
                    identifier = "identifier"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.feeds()
        val request = mockWebServer.takeRequest()
        assert(request.path == "/feeds")
        assert(request.method == "GET")
        assert(result == responseBody)
    }

    @Test
    fun testDeleteFeed() = runTest {
        val responseBody = ResponseWrapper(
            FeedResponse(
                _id = "123",
                name = "test",
                _environmentId = "enviromentId",
                _organizationId = "organizationId",
                identifier = "identifier",
                deleted = true
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val feedId = "123"
        val result = mockNovu.deleteFeed(feedId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/feeds/$feedId")
        assert(request.method == "DELETE")
        assert(result == responseBody)
    }
}
