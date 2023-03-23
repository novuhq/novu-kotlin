package co.novu.extentions

import co.novu.Novu
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.validateMxRecordSetupForInboundParse() = runBlocking {
    inboundParseApi.validateMxRecordSetupForInboundParse()
        .body()
        .apply { logger.info { this } }
}
