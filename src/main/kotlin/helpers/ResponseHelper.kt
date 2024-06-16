package co.novu.helpers

import mu.KLogger
import retrofit2.Response

fun <T> Response<T>.extractResponse(
    logger: KLogger,
    enableLogging: Boolean,
): T? {
    this.apply {
        return if (isSuccessful) {
            body().apply { if (enableLogging) logger.debug { this } }
        } else {
            throw Exception(errorBody()?.string())
        }
    }
}

fun <T, R> Response<T>.extractResponse(
    logger: KLogger,
    enableLogging: Boolean,
    body: R,
): R {
    this.apply {
        return if (isSuccessful) {
            body.apply { if (enableLogging) logger.debug { this } }
        } else {
            throw Exception(errorBody()?.string())
        }
    }
}
