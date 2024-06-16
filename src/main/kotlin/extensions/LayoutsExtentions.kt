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

suspend fun Novu.filterLayouts(
    page: BigInteger,
    pageSize: BigInteger,
    orderBy: BigInteger,
    sortBy: String,
): PaginatedResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.filterLayouts(page, pageSize, sortBy, orderBy)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.createLayout(request: CreateLayoutRequest): ResponseWrapper<CreateLayoutResponse>? {
    val response = layoutsApi.createLayout(request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.layout(layoutId: String): ResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.getLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.deleteLayout(layoutId: String): DeleteLayoutResponse {
    val response = layoutsApi.deleteLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging, DeleteLayoutResponse())
}

suspend fun Novu.updateLayout(
    layoutId: String,
    request: CreateLayoutRequest,
): ResponseWrapper<GetLayoutsResponse>? {
    val response = layoutsApi.updateLayout(layoutId, request)
    return response.extractResponse(logger, config.enableLogging)
}

suspend fun Novu.setDefaultLayout(layoutId: String): SetDefaultLayoutResponse {
    val response = layoutsApi.setDefaultLayout(layoutId)
    return response.extractResponse(logger, config.enableLogging, SetDefaultLayoutResponse())
}
