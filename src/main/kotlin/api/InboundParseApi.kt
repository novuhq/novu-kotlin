package co.novu.api

import co.novu.dto.validateMxRecordSetupForInboundParseResponse
import retrofit2.Response
import retrofit2.http.GET

interface InboundParseApi {

    @GET("inbound-parse/mx/status")
    suspend fun validateMxRecordSetupForInboundParse(): Response<validateMxRecordSetupForInboundParseResponse>
}
