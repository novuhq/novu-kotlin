package co.novu.extensions

import co.novu.Novu
import co.novu.dto.request.CreateByNameRequest
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

@Deprecated("Use getWorkflowGroups()")
fun Novu.notificationGroups() = runBlocking {
    val response = notificationGroupsApi.getNotificationGroups()
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.getWorkflowGroups() = runBlocking {
    val response = notificationGroupsApi.getNotificationGroups()
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

@Deprecated("Use createWorkflowGroup(request: CreateByNameRequest)")
fun Novu.createNotificationGroup(request: CreateByNameRequest) = runBlocking {
    val response = notificationGroupsApi.createNotificationGroup(request)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.createWorkflowGroup(request: CreateByNameRequest) = runBlocking {
    val response = notificationGroupsApi.createNotificationGroup(request)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.getWorkflowGroup(id: String) = runBlocking {
    val response = notificationGroupsApi.getWorkflowGroup(id)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.updateWorkflowGroup(id: String, request: CreateByNameRequest) = runBlocking {
    val response = notificationGroupsApi.updateWorkflowGroup(id, request)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}

fun Novu.deleteWorkflowGroup(id: String) = runBlocking {
    val response = notificationGroupsApi.deleteWorkflowGroup(id)
    if (response.isSuccessful) {
        response.body().apply { logger.debug { this } }
    } else {
        throw Exception(response.errorBody()?.string())
    }
}
