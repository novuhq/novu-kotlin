import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.blueprints.General
import co.novu.dto.blueprints.Popular
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.getBlueprint
import co.novu.extensions.getBlueprintsByCategory
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BlueprintsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetBlueprintsByCategory() = runTest {
        val responseBody = ResponseWrapper(
            data = BlueprintsResponse(
                general = listOf(General()),
                popular = Popular(
                    name = "popular",
                    blueprints = listOf(
                        Blueprint(
                            name = "name",
                            active = true,
                            description = "description"
                        )
                    )
                )
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.getBlueprintsByCategory()
        val request = mockWebServer.takeRequest()

        assert(request.path == "/blueprints/group-by-category")
        assert(request.method == "GET")
        assert(request.headers["Authorization"] != null)
        assert(request.headers["User-Agent"] != null)
        assert(result == responseBody)
    }

    @Test
    fun testGetBlueprint() = runTest {
        val templateId = ""
        val responseBody = Blueprint(
            name = "name",
            active = true,
            description = "description"
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(Gson().toJson(responseBody)))
        val result = mockNovu.getBlueprint(templateId)
        val request = mockWebServer.takeRequest()

        assert(request.path == "/blueprints/$templateId")
        assert(request.method == "GET")
        assert(result == responseBody)
    }
}
