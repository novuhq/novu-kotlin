import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateByNameRequest
import co.novu.dto.request.topics.CreateTopicRequest
import co.novu.dto.response.AddSubscribersResponse
import co.novu.dto.response.CreateTopicResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.SubscriberList
import co.novu.dto.response.topics.TopicResponse
import co.novu.extensions.addSubscribers
import co.novu.extensions.createTopic
import co.novu.extensions.filterTopics
import co.novu.extensions.getTopic
import co.novu.extensions.removeSubscriber
import co.novu.extensions.renameTopic
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class TopicsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testFilterTopics() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                TopicResponse(
                    _id = "_id",
                    _organizationId = "_organizationId",
                    _environmentId = "_environmentId",
                    key = "key",
                    name = "name",
                    subscribers = listOf("subscriber")
                )
            ),
            totalCount = BigInteger.TEN
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val page = BigInteger.ONE
        val pageSize = BigInteger.TEN
        val key = "key"
        val result = mockNovu.filterTopics(page, pageSize, key)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/topics?page=$page&pageSize=$pageSize&key=$key")
        assert(responseBody == result)
    }

    @Test
    fun testCreateTopic() = runTest {
        val responseBody = ResponseWrapper(
            CreateTopicResponse(
                _id = "_id",
                key = "key"
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )

        val requestBody = CreateTopicRequest(
            key = "key",
            name = "name"
        )
        val result = mockNovu.createTopic(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/topics")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(responseBody == result)
    }

    @Test
    fun testAddSubscribers() = runTest {
        val resposeBody = ResponseWrapper(
            data = AddSubscribersResponse(
                succeeded = listOf("test_topic"),
                failed = null
            )
        )

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(resposeBody))
        )
        val topicKey = "key"
        val requestBody = SubscriberList(listOf("name"))
        val result = mockNovu.addSubscribers(topicKey, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/topics/$topicKey/subscribers")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(resposeBody == result)
    }

    @Test
    fun testRemoveSubscribers() = runTest {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(204)
        )
        val topicKey = "key"
        val requestBody = SubscriberList(listOf("name"))
        mockNovu.removeSubscriber(topicKey, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/topics/$topicKey/subscribers/removal")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
    }

    @Test
    fun testGetTopic() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                TopicResponse(
                    _id = "64059e4de5d10c2178aa8078",
                    _organizationId = "63f71b3cf067290fa6691032",
                    _environmentId = "63f71b3cf067290fa6691038",
                    key = "test-topics",
                    name = "yooo",
                    subscribers = listOf("test_shivam")
                )
            ),
            totalCount = BigInteger.TEN
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val topicKey = "test-topics"
        val result = mockNovu.getTopic(topicKey)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/topics/?topicKey=$topicKey")
        assert(responseBody == result)
    }

    @Test
    fun testRenameTopic() = runTest {
        val responseBody = ResponseWrapper(
            data = TopicResponse(
                _id = "_id",
                _organizationId = "_organizationId",
                _environmentId = "_environmentId",
                key = "key",
                name = "name",
                subscribers = listOf("subscriber")
            )
        )

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )

        val requestBody = CreateByNameRequest(
            name = "name"
        )
        val topicKey = "key"
        val result = mockNovu.renameTopic(topicKey = topicKey, request = requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PATCH")
        assert(request.path == "/topics/$topicKey")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(responseBody == result)
    }
}
