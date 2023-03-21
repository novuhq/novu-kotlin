package co.novu.dto.request

import co.novu.dto.DNS

class UpdateEnvironmentRequest {
    var name: String? = null
    var identifier: String? = null
    var parentId: String? = null
    var dns: DNS? = null
}