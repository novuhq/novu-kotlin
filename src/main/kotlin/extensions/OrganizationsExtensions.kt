package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateOrganizationRequest
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import dto.Branding
import dto.request.UpdateMemberRoleRequest
import dto.request.UpdateOrganizationBrandRequest
import dto.request.UpdateOrganizationNameRequest
import dto.response.MemberResponse
import dto.response.OrganizationResponse
import dto.response.UpdateOrganizationNameResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Create an Organization.
 * @param request an instance of [CreateOrganizationRequest]
 * @return [ResponseWrapper] with [OrganizationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createOrganization(request: CreateOrganizationRequest): ResponseWrapper<OrganizationResponse>? {
    val response = organizationsApi.createOrganization(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of all Organizations.
 * @return [ResponseWrapper] with a list of [OrganizationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.fetchAllOrganizations(): ResponseWrapper<List<OrganizationResponse>>? {
    val response = organizationsApi.fetchAllOrganizations()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update the name of an Organization.
 * @param request an instance of [UpdateOrganizationNameRequest]
 * @return [ResponseWrapper] with [UpdateOrganizationNameResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateOrganizationName(request: UpdateOrganizationNameRequest): ResponseWrapper<UpdateOrganizationNameResponse>? {
    val response = organizationsApi.updateOrganizationName(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve the data of the current Organization.
 * @return [ResponseWrapper] with [OrganizationResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.fetchCurrentOrganization(): ResponseWrapper<OrganizationResponse>? {
    val response = organizationsApi.fetchCurrentOrganization()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Remove a Member from the current Organization.
 * @param memberId the ID of the Member to be removed
 * @return [ResponseWrapper] with [MemberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.removeMemberWithId(memberId: String): ResponseWrapper<MemberResponse>? {
    val response = organizationsApi.removeMemberWithId(memberId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Member's role in the current Organization.
 * @param memberId the ID of the Member to be updated
 * @param request an instance of [UpdateMemberRoleRequest]
 * @return [ResponseWrapper] with [MemberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateMemberRole(
    memberId: String,
    request: UpdateMemberRoleRequest,
): ResponseWrapper<MemberResponse>? {
    val response = organizationsApi.updateMemberRole(memberId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a list of all Members in the current Organizations.
 * @return [ResponseWrapper] with a list of [MemberResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.fetchMembersOfOrganization(): ResponseWrapper<List<MemberResponse>>? {
    val response = organizationsApi.fetchMembersOfOrganization()
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update the brand of the current Organization.
 * @param request an instance of [UpdateOrganizationBrandRequest]
 * @return [ResponseWrapper] with [Branding] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateOrganizationBrand(request: UpdateOrganizationBrandRequest): ResponseWrapper<Branding>? {
    val response = organizationsApi.updateOrganizationBrand(request)
    return response.extractResponse(logger, config.enableLogging)
}
