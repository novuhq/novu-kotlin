import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.Tenant
import co.novu.dto.request.TenantRequest
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.createTenant
import co.novu.extensions.deleteTenant
import co.novu.extensions.getTenant
import co.novu.extensions.getTenants
import co.novu.extensions.updateTenant
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test
import java.math.BigInteger

@OptIn(ExperimentalCoroutinesApi::class)
class TenantsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )

    @Test
    fun testGetTenants() = runTest {
        val responseBody = PaginatedResponseWrapper(
            data = listOf(
                Tenant(
                    _id = "_id",
                    _environmentId = "_environmentId",
                    name = "name",
                    identifier = "identifier"
                )
            ),
            pageSize = BigInteger.TEN
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val page = 1
        val limit = 10
        val result = mockNovu.getTenants(page, limit)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/tenants?page=$page&limit=$limit")
        assert(responseBody == result)
    }

    @Test
    fun testCreateTenant() = runTest {
        val responseBody = ResponseWrapper(
            Tenant(
                _id = "_id",
                _environmentId = "_environmentId",
                name = "name",
                identifier = "identifier"
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(201)
                .setBody(Gson().toJson(responseBody))
        )

        val requestBody = TenantRequest(
            name = "name",
            identifier = "identifier"
        )
        val result = mockNovu.createTenant(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/tenants")
        assert(request.body.readUtf8() == Gson().toJson(requestBody))
        assert(responseBody == result)
    }

    @Test
    fun testGetTenant() = runTest {
        val responseBody = ResponseWrapper(
            data = Tenant(
                _id = "_id",
                _environmentId = "_environmentId",
                name = "name",
                identifier = "identifier"
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val identifier = "identifier"
        val result = mockNovu.getTenant(identifier)
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/tenants/$identifier")
        assert(responseBody == result)
    }

    @Test
    fun testUpdateTenant() = runTest {
        val responseBody = ResponseWrapper(
            data = Tenant(
                _id = "_id",
                _environmentId = "_environmentId",
                name = "name",
                identifier = "identifier"
            )
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Gson().toJson(responseBody))
        )
        val requestBody = TenantRequest(
            name = "name",
            identifier = "identifier"
        )
        val identifier = "identifier"
        val result = mockNovu.updateTenant(identifier, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PATCH")
        assert(request.path == "/tenants/$identifier")
        assert(responseBody == result)
    }

    @Test
    fun testDeleteTenant() = runTest {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(204)
        )
        val identifier = "identifier"
        val response = mockNovu.deleteTenant(identifier)
        val request = mockWebServer.takeRequest()

        assert(request.method == "DELETE")
        assert(request.path == "/tenants/$identifier")
        assert(response.acknowledged)
    }
}
