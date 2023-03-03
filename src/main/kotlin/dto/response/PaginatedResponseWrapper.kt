package co.novu.dto.response

import java.math.BigInteger

data class PaginatedResponseWrapper<T>(
    var page: BigInteger,
    var totalCount: BigInteger,
    var pageSize: BigInteger,
    var data: List<T>
)