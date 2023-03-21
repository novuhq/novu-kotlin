package co.novu.extentions

import co.novu.Novu
import co.novu.dto.request.CreateLayoutRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getLayouts(page:BigInteger, pageSize: BigInteger,orderBy: BigInteger,sortBy:String) = runBlocking {
    layoutsApi.getLayouts(page,pageSize,sortBy,orderBy)
        .body()
        .apply { logger.info { this } }
}

fun Novu.createLayout(request: CreateLayoutRequest) = runBlocking {
    layoutsApi.createLayout(request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.getLayout(layoutId: String) = runBlocking {
    layoutsApi.getLayout(layoutId)
        .body()
        .apply { logger.info { this } }
}

fun Novu.deleteLayout(layoutId: String) = runBlocking {
    layoutsApi.deleteLayout(layoutId)
        .apply { logger.info { this } }
}

fun Novu.updateLayout(layoutId: String, request: CreateLayoutRequest) = runBlocking {
    layoutsApi.updateLayout(layoutId, request)
        .body()
        .apply { logger.info { this } }
}

fun Novu.setDefaultLayout(layoutId: String) = runBlocking {
    layoutsApi.setDefaultLayout(layoutId)
        .apply { logger.info { this } }
}