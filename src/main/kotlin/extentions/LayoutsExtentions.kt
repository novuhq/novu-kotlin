package co.novu.extentions

import co.novu.Novu
import co.novu.dto.request.CreateLayoutRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.filterLayouts(page: BigInteger, pageSize: BigInteger, orderBy: BigInteger, sortBy: String) = runBlocking {
    val response = layoutsApi.filterLayouts(page, pageSize, sortBy, orderBy)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.createLayout(request: CreateLayoutRequest) = runBlocking {
    val response = layoutsApi.createLayout(request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.layout(layoutId: String) = runBlocking {
    val response = layoutsApi.getLayout(layoutId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.deleteLayout(layoutId: String) = runBlocking {
    val response = layoutsApi.deleteLayout(layoutId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.updateLayout(layoutId: String, request: CreateLayoutRequest) = runBlocking {
    val response = layoutsApi.updateLayout(layoutId, request)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.setDefaultLayout(layoutId: String) = runBlocking {
    val response = layoutsApi.setDefaultLayout(layoutId)
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
