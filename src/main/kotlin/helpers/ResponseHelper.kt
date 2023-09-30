package co.novu.helpers

import mu.KLogger
import retrofit2.Response

fun <T> Response<T>.extractResponse(logger: KLogger): T? {
    this.apply {
        return if (isSuccessful) {
            body().apply { logger.debug { this } }
        } else {
            throw Exception(errorBody()?.string())
        }
    }
}
