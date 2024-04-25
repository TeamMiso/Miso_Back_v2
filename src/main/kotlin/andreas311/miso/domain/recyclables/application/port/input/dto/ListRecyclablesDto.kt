package andreas311.miso.domain.recyclables.application.port.input.dto

data class ListRecyclablesDto(
    val recyclablesList: List<RecyclablesDto>
) {
    constructor() : this(emptyList())
}
