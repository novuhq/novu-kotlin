package co.novu.extensions

import co.novu.Novu
import co.novu.dto.Tenant
import co.novu.dto.request.TenantRequest
import co.novu.dto.response.DeleteTenantResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Tenants. This function supports pagination.
 * @param page the page number to be retrieved
 * @param limit the size of the page to be retrieved
 * @return [PaginatedResponseWrapper] with a list of [Tenant] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getTenants(
    page: Int? = null,
    limit: Int? = null,
): PaginatedResponseWrapper<Tenant>? {
    val response = tenantsApi.getTenants(page, limit)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a Tenant.
 * @param request an instance of [TenantRequest]
 * @return [ResponseWrapper] with [Tenant] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createTenant(request: TenantRequest): ResponseWrapper<Tenant>? {
    val response = tenantsApi.createTenant(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Tenant.
 * @param identifier the ID of the Tenant to be retrieved
 * @return [ResponseWrapper] with [Tenant] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.getTenant(identifier: String): ResponseWrapper<Tenant>? {
    val response = tenantsApi.getTenant(identifier)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Update a Tenant.
 * @param identifier the ID of the Tenant to be updated
 * @param request an instance of [TenantRequest]
 * @return [ResponseWrapper] with [Tenant] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateTenant(
    identifier: String,
    request: TenantRequest,
): ResponseWrapper<Tenant>? {
    val response = tenantsApi.updateTenant(identifier, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Tenant.
 * @param identifier the ID of the Tenant to be deleted
 * @return [DeleteTenantResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteTenant(identifier: String): DeleteTenantResponse {
    val response = tenantsApi.deleteTenant(identifier)
    return response.extractResponse(logger, config.enableLogging, DeleteTenantResponse())
}
