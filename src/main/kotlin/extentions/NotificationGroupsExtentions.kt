package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun Novu.notificationGroups() = runBlocking {
    val response = notificationGroupsApi.getNotificationGroups()
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.createNotificationGroup(request: CreateByNameRequest) = runBlocking {
    val response = notificationGroupsApi.createNotificationGroup(request)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
