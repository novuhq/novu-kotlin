package co.novu.api

import co.novu.dto.ValidateMxRecordSetupForInboundParseResponse
import retrofit2.Response
import retrofit2.http.GET

interface InboundParseApi {
    companion object {
        const val ENDPOINT = "inbound-parse"
    }

    @GET("$ENDPOINT/mx/status")
    suspend fun validateMxRecordSetupForInboundParse(): Response<ValidateMxRecordSetupForInboundParseResponse>
}
