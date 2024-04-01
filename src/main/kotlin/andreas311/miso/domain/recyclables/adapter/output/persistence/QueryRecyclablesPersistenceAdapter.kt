package andreas311.miso.domain.recyclables.adapter.output.persistence

import andreas311.miso.domain.recyclables.adapter.output.persistence.mapper.RecyclablesMapper
import andreas311.miso.domain.recyclables.adapter.output.persistence.repository.RecyclablesRepository
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.domain.recyclables.domain.RecyclablesType
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class QueryRecyclablesPersistenceAdapter(
    private val recyclablesMapper: RecyclablesMapper,
    private val recyclablesRepository: RecyclablesRepository
) : QueryRecyclablesPort {
    override fun findByIdOrNull(id: Long): Recyclables? {
        val recyclablesEntity = recyclablesRepository.findByIdOrNull(id)
        return recyclablesMapper toDomain recyclablesEntity
    }

    override fun findByRecyclablesTypeOrNull(recyclablesType: RecyclablesType): Recyclables? {
        val recyclablesEntity = recyclablesRepository.findByRecyclablesType(recyclablesType)
        return recyclablesMapper toDomain recyclablesEntity
    }
}