package co.novu.extensions

import co.novu.Novu
import co.novu.dto.ValidateMxRecordSetupForInboundParseResponse
import co.novu.helpers.extractResponse
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * Validate the mx record setup for the inbound parse functionality.
 * @return [ValidateMxRecordSetupForInboundParseResponse]
 * @throws [Exception] if a problem occurred talking to the server or if there is a connection error
 */
suspend fun Novu.validateMxRecordSetupForInboundParse(): ValidateMxRecordSetupForInboundParseResponse? {
    val response = inboundParseApi.validateMxRecordSetupForInboundParse()
    return response.extractResponse(logger, config.enableLogging)
}
