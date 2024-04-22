package andreas311.miso.domain.recyclables.application.port.input

import andreas311.miso.domain.recyclables.application.port.input.dto.RecyclablesDto

interface SearchRecyclablesUseCase {
    fun execute(searchValue: String): RecyclablesDto
}