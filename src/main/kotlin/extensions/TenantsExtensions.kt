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

suspend fun Novu.getTenants(page: Int? = null, limit: Int? = null): PaginatedResponseWrapper<Tenant>? {
    val response = tenantsApi.getTenants(page, limit)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createTenant(request: TenantRequest): ResponseWrapper<Tenant>? {
    val response = tenantsApi.createTenant(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.getTenant(identifier: String): ResponseWrapper<Tenant>? {
    val response = tenantsApi.getTenant(identifier)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.updateTenant(identifier: String, request: TenantRequest): ResponseWrapper<Tenant>? {
    val response = tenantsApi.updateTenant(identifier, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteTenant(identifier: String): DeleteTenantResponse {
    val response = tenantsApi.deleteTenant(identifier)
    return response.extractResponse(logger, config.enableLogging, DeleteTenantResponse())
}
