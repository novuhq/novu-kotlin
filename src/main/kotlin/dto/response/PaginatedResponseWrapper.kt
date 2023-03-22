package co.novu.dto.response

import java.math.BigInteger

data class PaginatedResponseWrapper<T>(
    var page: BigInteger? = BigInteger.ONE,
    var totalCount: BigInteger,
    var pageSize: BigInteger? = BigInteger.TEN,
    var data: List<T>
)
