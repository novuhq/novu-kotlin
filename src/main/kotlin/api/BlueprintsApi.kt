package co.novu.api

import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BlueprintsApi {

    @GET("blueprints/group-by-category")
    suspend fun getBlueprintsByCategory(): Response<ResponseWrapper<BlueprintsResponse>>

    @GET("blueprints/{templateId}")
    suspend fun getBlueprint(@Path("templateId") templateId: String): Response<Blueprint>
}
