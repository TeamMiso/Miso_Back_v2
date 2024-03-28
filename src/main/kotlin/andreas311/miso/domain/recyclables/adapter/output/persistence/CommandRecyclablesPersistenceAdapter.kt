package andreas311.miso.domain.recyclables.adapter.output.persistence

import andreas311.miso.domain.recyclables.adapter.output.persistence.mapper.RecyclablesMapper
import andreas311.miso.domain.recyclables.adapter.output.persistence.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.application.port.output.CommandRecyclablesPort
import andreas311.miso.domain.recyclables.domain.Recyclables
import org.springframework.stereotype.Component

@Component
class CommandRecyclablesPersistenceAdapter(
    private val recyclablesMapper: RecyclablesMapper,
    private val recyclablesRepository: RecyclablesRepository
) : CommandRecyclablesPort {
    override fun saveRecyclables(recyclables: Recyclables): Recyclables {
        val recyclablesEntity = recyclablesRepository.save(recyclablesMapper toEntity recyclables)
        return recyclablesMapper.toDomain(recyclablesEntity)!!
    }
}