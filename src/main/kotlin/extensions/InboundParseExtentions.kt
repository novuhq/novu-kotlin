package co.novu.extensions

import co.novu.Novu
import co.novu.dto.ValidateMxRecordSetupForInboundParseResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun Novu.validateMxRecordSetupForInboundParse(): ValidateMxRecordSetupForInboundParseResponse? {
    val response = inboundParseApi.validateMxRecordSetupForInboundParse()
    return response.extractResponse(logger, config.enableLogging)
}
