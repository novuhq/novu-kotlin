package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.math.BigInteger

private val logger = KotlinLogging.logger {}

fun Novu.getNotificationGroups() = runBlocking {
    notificationGroupsApi.getNotificationGroups()
        .body()
        .apply { logger.info { this } }
}

fun Novu.createNotificationGroup(request: CreateByNameRequest) = runBlocking {
    notificationGroupsApi.createNotificationGroup(request)
        .body()
        .apply { logger.info { this } }
}
