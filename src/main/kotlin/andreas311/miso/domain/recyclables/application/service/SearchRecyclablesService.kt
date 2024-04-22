package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.recyclables.application.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.application.port.input.SearchRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.RecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort

@ReadOnlyRollbackService
class SearchRecyclablesService(
    private val queryRecyclablesPort: QueryRecyclablesPort
) : SearchRecyclablesUseCase {
    override fun execute(searchValue: String): RecyclablesDto {
        val recyclables = queryRecyclablesPort.search(searchValue)
            ?: throw RecyclablesNotFoundException()

        return RecyclablesDto(recyclables)
    }
}