package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateLayoutRequest
import co.novu.dto.response.CreateLayoutResponse
import co.novu.dto.response.DeleteLayoutResponse
import co.novu.dto.response.GetLayoutsResponse
import co.novu.dto.response.PaginatedResponseWrapper
import co.novu.dto.response.ResponseWrapper
import co.novu.dto.response.SetDefaultLayoutResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

/**
 * Retrieve a list of Layouts This function supports pagination.
 * @param page the page number to be retrieved
 * @param pageSize the size of the page to be retrieved
 * @param orderBy direction of the sorting query param. Either ascending (1) or descending (-1)
 * @param sortBy sort field. Currently only supports **createdAt**
 * @return [PaginatedResponseWrapper] with a list of [GetLayoutsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.filterLayouts(
    page: BigInteger,
    pageSize: BigInteger,
    orderBy: BigInteger,
    sortBy: String,
): PaginatedResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.filterLayouts(page, pageSize, sortBy, orderBy)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Create a Layout.
 * @param request an instance of [CreateLayoutRequest]
 * @return [ResponseWrapper] with [CreateLayoutResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.createLayout(request: CreateLayoutRequest): ResponseWrapper<CreateLayoutResponse>? {
    val response = layoutsApi.createLayout(request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Retrieve a Layout.
 * @param layoutId the ID of the Layout to be retrieved
 * @return [ResponseWrapper] with [GetLayoutsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.layout(layoutId: String): ResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.getLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Delete a Layout.
 * @param layoutId the ID of the Layout to be deleted
 * @return [DeleteLayoutResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.deleteLayout(layoutId: String): DeleteLayoutResponse {
    val response = layoutsApi.deleteLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging, DeleteLayoutResponse())
}

/**
 * Update a Layout.
 * @param layoutId the ID of the Layout to be updated
 * @param request an instance of [CreateLayoutRequest]
 * @return [ResponseWrapper] with [GetLayoutsResponse] as the response data
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.updateLayout(
    layoutId: String,
    request: CreateLayoutRequest,
): ResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.updateLayout(layoutId, request)
    return response.extractResponse(logger, config.enableLogging)
}

/**
 * Set a Layout as the default Layout.
 * @param layoutId the ID of the Layout to be set as default
 * @return [SetDefaultLayoutResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.setDefaultLayout(layoutId: String): SetDefaultLayoutResponse {
    val response = layoutsApi.setDefaultLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging, SetDefaultLayoutResponse())
}
