package co.novu.extentions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.validateMxRecordSetupForInboundParse() = runBlocking {
    val response = inboundParseApi.validateMxRecordSetupForInboundParse()
    if (response.isSuccessful) {
        response.body().apply { logger.info { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
