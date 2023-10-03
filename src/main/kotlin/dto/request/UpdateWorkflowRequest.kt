package co.novu.dto.request

import dto.request.BaseWorkflowRequest

data class UpdateWorkflowRequest(
    var identifier: String? = null
) : BaseWorkflowRequest()
