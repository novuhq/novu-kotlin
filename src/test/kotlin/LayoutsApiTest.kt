import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateLayoutRequest
import co.novu.dto.response.CreateLayoutResponse
import co.novu.dto.response.GetLayoutsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.extentions.createLayout
import co.novu.extentions.deleteLayout
import co.novu.extentions.filterLayouts
import co.novu.extentions.getLayout
import co.novu.extentions.setDefaultLayout
import co.novu.extentions.updateLayout
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class LayoutsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        apiKey = "1245",
        NovuConfig(backendUrl = mockWebServer.url("/"))
    )

    @Test
    fun testCreateLayout() = runTest {
        val responseBody = CreateLayoutResponse(
            _id = "_id"
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )

        val requestBody = CreateLayoutRequest(
            name = "name",
            description = "description",
            content = "content",
            isDefault = true,
            variables = listOf("variables")
        )
        val result = mockNovu.createLayout(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/layouts")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testGetLayouts() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                GetLayoutsResponse(
                    _id = "_id",
                    name = "name",
                    description = "description",
                    content = "content",
                    isDefault = true,
                    variables = listOf("variables")
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
        val sortBy = "sortBy"
        val orderBy = BigInteger.ONE
        val result = mockNovu.filterLayouts(page, pageSize, orderBy, sortBy)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/layouts?page=$page&pageSize=$pageSize&sortBy=$sortBy&orderBy=$orderBy")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testGetLayout() = runTest {
        val responseBody = GetLayoutsResponse(
            _id = "_id",
            _organizationId = "_organizationId",
            _environmentId = "_environmentId",
            _creatorId = "_creatorId",
            name = "name",
            description = "description",
            channel = "channel",
            content = "content",
            variables = listOf("variables"),
            isDefault = true,
            isDeleted = true,
            createdAt = "createdAt",
            updatedAt = "updatedAt",
            _parentId = "_parentId"
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val layoutId = "layoutId"
        val result = mockNovu.getLayout(layoutId)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/layouts/$layoutId")
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testDeleteLayout() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(204))
        val layoutId = "layoutId"
        mockNovu.deleteLayout(layoutId)
        val request = mockWebServer.takeRequest()
        assert(request.method == "DELETE")
        assert(request.path == "/layouts/$layoutId")
    }

    @Test
    fun testUpdateLayout() = runTest {
        val responseBody = GetLayoutsResponse(
            _id = "_id",
            _organizationId = "_organizationId",
            _environmentId = "_environmentId",
            _creatorId = "_creatorId",
            name = "name",
            description = "description",
            channel = "channel",
            content = "content",
            variables = listOf("variables"),
            isDefault = true,
            isDeleted = true,
            createdAt = "createdAt",
            updatedAt = "updatedAt",
            _parentId = "_parentId"
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val layoutId = "layoutId"
        val requestBody = CreateLayoutRequest(
            name = "name",
            description = "description",
            content = "content",
            isDefault = true,
            variables = listOf("variables")
        )
        val result = mockNovu.updateLayout(layoutId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PATCH")
        assert(request.path == "/layouts/$layoutId")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(Gson().toJson(responseBody) == Gson().toJson(result))
    }

    @Test
    fun testSetDefaultLayout() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(204))
        val layoutId = "layoutId"
        mockNovu.setDefaultLayout(layoutId)
        val request = mockWebServer.takeRequest()
        assert(request.method == "POST")
        assert(request.path == "/layouts/$layoutId/default")
    }

}
