package co.novu.dto.blueprints

data class BlueprintsResponse(
    private var general: List<General>? = null,
    private var popular: Popular? = null
)
