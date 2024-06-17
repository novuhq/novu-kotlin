package co.novu.api

import co.novu.dto.blueprints.Blueprint
import co.novu.dto.blueprints.BlueprintsResponse
import co.novu.dto.response.ResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BlueprintsApi {
    companion object {
        const val ENDPOINT = "blueprints"
    }

    @GET("$ENDPOINT/group-by-category")
    suspend fun getBlueprintsByCategory(): Response<ResponseWrapper<BlueprintsResponse>>

    @GET("$ENDPOINT/{templateId}")
    suspend fun getBlueprint(
        @Path("templateId") templateId: String,
    ): Response<Blueprint>
}
