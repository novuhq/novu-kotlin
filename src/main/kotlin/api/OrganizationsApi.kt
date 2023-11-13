package co.novu.api

import co.novu.dto.request.CreateOrganizationRequest
import co.novu.dto.response.ResponseWrapper
import dto.Branding
import dto.request.UpdateMemberRoleRequest
import dto.request.UpdateOrganizationBrandRequest
import dto.request.UpdateOrganizationNameRequest
import dto.response.MemberResponse
import dto.response.OrganizationResponse
import dto.response.UpdateOrganizationNameResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrganizationsApi {

    companion object {
        const val ENDPOINT = "organizations"
    }

    @POST(ENDPOINT)
    suspend fun createOrganization(@Body request: CreateOrganizationRequest): Response<ResponseWrapper<OrganizationResponse>>

    @GET(ENDPOINT)
    suspend fun fetchAllOrganizations(): Response<ResponseWrapper<List<OrganizationResponse>>>

    @PATCH(ENDPOINT)
    suspend fun updateOrganizationName(@Body request: UpdateOrganizationNameRequest): Response<ResponseWrapper<UpdateOrganizationNameResponse>>

    @GET("$ENDPOINT/me")
    suspend fun fetchCurrentOrganization(): Response<ResponseWrapper<OrganizationResponse>>

    @DELETE("$ENDPOINT/members/{memberId}")
    suspend fun removeMemberWithId(@Path("memberId") memberId: String): Response<ResponseWrapper<MemberResponse>>

    @PUT("$ENDPOINT/members/{memberId}/roles")
    suspend fun updateMemberRole(@Path("memberId") memberId: String, @Body request: UpdateMemberRoleRequest): Response<ResponseWrapper<MemberResponse>>

    @GET("$ENDPOINT/members")
    suspend fun fetchMembersOfOrganization(): Response<ResponseWrapper<List<MemberResponse>>>

    @PUT("$ENDPOINT/branding")
    suspend fun updateOrganizationBrand(@Body request: UpdateOrganizationBrandRequest): Response<ResponseWrapper<Branding>>
}
