import co.novu.Novu
import co.novu.NovuConfig
import co.novu.dto.request.CreateOrganizationRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.extensions.createOrganization
import co.novu.extensions.fetchAllOrganizations
import co.novu.extensions.fetchCurrentOrganization
import co.novu.extensions.fetchMembersOfOrganization
import co.novu.extensions.removeMemberWithId
import co.novu.extensions.updateMemberRole
import co.novu.extensions.updateOrganizationBrand
import co.novu.extensions.updateOrganizationName
import com.google.gson.Gson
import dto.Branding
import dto.request.UpdateMemberRoleRequest
import dto.request.UpdateOrganizationBrandRequest
import dto.request.UpdateOrganizationNameRequest
import dto.response.MemberResponse
import dto.response.OrganizationResponse
import dto.response.UpdateOrganizationNameResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class OrganizationsApiTest {
    private val mockWebServer = MockWebServer()
    private val mockNovu = Novu(
        NovuConfig(apiKey = "1245", backendUrl = mockWebServer.url("").toString())
    )
    private val gson = Gson()

    @Test
    fun testCreateOrganization() = runTest {
        val responseBody = ResponseWrapper(
            data = OrganizationResponse(
                name = "Org. name",
                logo = "logo URI",
                branding = Branding(
                    color = "#ffffff",
                    fontColor = "#000000",
                    logo = "logo URI"
                )
            )
        )

        val requestBody = CreateOrganizationRequest(
            name = "Org. name",
            logo = "logo URI"
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))
        val result = mockNovu.createOrganization(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "POST")
        assert(request.path == "/organizations")
        assert(request.body.readUtf8() == gson.toJson(requestBody))
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testFetchAllOrganizations() = runTest {
        val responseBody = ResponseWrapper(
            data = listOf(
                OrganizationResponse(
                    name = "Org. name1",
                    logo = "logo URI",
                    branding = Branding(
                        color = "#ffffff",
                        fontColor = "#000000",
                        logo = "logo URI"
                    )
                ),
                OrganizationResponse(
                    name = "Org. name2",
                    logo = "logo URI",
                    branding = Branding(
                        color = "#ffffff",
                        fontColor = "#000000",
                        logo = "logo URI"
                    )
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))
        val result = mockNovu.fetchAllOrganizations()
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/organizations")
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testUpdateOrganizationName() = runTest {
        val responseBody = ResponseWrapper(
            data = UpdateOrganizationNameResponse(
                name = "Org. new name"
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))
        val requestBody = UpdateOrganizationNameRequest(
            name = "Org. new name"
        )
        val result = mockNovu.updateOrganizationName(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PATCH")
        assert(request.path == "/organizations")
        assert(request.body.readUtf8() == gson.toJson(requestBody))
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testFetchCurrentOrganization() = runTest {
        val responseBody = ResponseWrapper(
            data = OrganizationResponse(
                name = "Org. name",
                logo = "logo URI",
                branding = Branding(
                    color = "#ffffff",
                    fontColor = "#000000",
                    logo = "logo URI"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))

        val result = mockNovu.fetchCurrentOrganization()
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/organizations/me")
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testRemoveMemberWithId() = runTest {
        val responseBody = ResponseWrapper(
            data = MemberResponse(
                id = "id",
                userId = "userId",
                organizationId = "orgId"
            )
        )
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))

        val memberId = "_id"
        val result = mockNovu.removeMemberWithId(memberId)
        val request = mockWebServer.takeRequest()

        assert(request.method == "DELETE")
        assert(request.path == "/organizations/members/$memberId")
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testUpdateMemberRole() = runTest {
        val responseBody = ResponseWrapper(
            data = MemberResponse(
                id = "id",
                userId = "userId",
                organizationId = "orgId"
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))

        val memberId = "_id"
        val requestBody = UpdateMemberRoleRequest(
            role = "New Role"
        )

        val result = mockNovu.updateMemberRole(memberId, requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PUT")
        assert(request.path == "/organizations/members/$memberId/roles")
        assert(request.body.readUtf8() == gson.toJson(requestBody))
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testFetchMembersOfOrganization() = runTest {
        val responseBody = ResponseWrapper(
            data = listOf(
                MemberResponse(
                    id = "id1",
                    userId = "userId",
                    organizationId = "orgId"
                ),
                MemberResponse(
                    id = "id2",
                    userId = "userId",
                    organizationId = "orgId"
                )
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))

        val result = mockNovu.fetchMembersOfOrganization()
        val request = mockWebServer.takeRequest()

        assert(request.method == "GET")
        assert(request.path == "/organizations/members")
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }

    @Test
    fun testUpdateOrganizationBrand() = runTest {
        val responseBody = ResponseWrapper(
            data = Branding(
                logo = "New logo URI",
                color = "#deklhd",
                fontFamily = "Sans Serif"
            )
        )

        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(gson.toJson(responseBody)))

        val requestBody = UpdateOrganizationBrandRequest(
            logo = "New logo URI",
            color = "#deklhd",
            fontFamily = "Sans Serif"
        )

        val result = mockNovu.updateOrganizationBrand(requestBody)
        val request = mockWebServer.takeRequest()

        assert(request.method == "PUT")
        assert(request.path == "/organizations/branding")
        assert(request.body.readUtf8() == gson.toJson(requestBody))
        assert(gson.toJson(responseBody) == gson.toJson(result))
    }
}
