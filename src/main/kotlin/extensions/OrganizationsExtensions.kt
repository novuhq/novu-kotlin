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

suspend fun Novu.createOrganization(request: CreateOrganizationRequest): ResponseWrapper<OrganizationResponse>? {
    val response = organizationsApi.createOrganization(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.fetchAllOrganizations(): ResponseWrapper<List<OrganizationResponse>>? {
    val response = organizationsApi.fetchAllOrganizations()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateOrganizationName(request: UpdateOrganizationNameRequest): ResponseWrapper<UpdateOrganizationNameResponse>? {
    val response = organizationsApi.updateOrganizationName(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.fetchCurrentOrganization(): ResponseWrapper<OrganizationResponse>? {
    val response = organizationsApi.fetchCurrentOrganization()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.removeMemberWithId(memberId: String): ResponseWrapper<MemberResponse>? {
    val response = organizationsApi.removeMemberWithId(memberId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateMemberRole(
    memberId: String,
    request: UpdateMemberRoleRequest,
): ResponseWrapper<MemberResponse>? {
    val response = organizationsApi.updateMemberRole(memberId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.fetchMembersOfOrganization(): ResponseWrapper<List<MemberResponse>>? {
    val response = organizationsApi.fetchMembersOfOrganization()
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateOrganizationBrand(request: UpdateOrganizationBrandRequest): ResponseWrapper<Branding>? {
    val response = organizationsApi.updateOrganizationBrand(request)
    return response.extractResponse(logger, config.enableLogging)
}
