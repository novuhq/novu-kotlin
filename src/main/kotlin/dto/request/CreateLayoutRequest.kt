package co.novu.dto.request

data class CreateLayoutRequest(
    var name: String,
    var description: String,
    var content: String,
    var variables: List<Any>,
    var isDefault: Boolean,
)