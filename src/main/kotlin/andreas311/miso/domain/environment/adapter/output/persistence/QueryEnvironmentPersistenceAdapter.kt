package andreas311.miso.domain.environment.adapter.output.persistence

import andreas311.miso.domain.environment.adapter.output.persistence.mapper.EnvironmentMapper
import andreas311.miso.domain.environment.adapter.output.persistence.repository.EnvironmentRepository
import andreas311.miso.domain.environment.application.port.output.QueryEnvironmentPort
import andreas311.miso.domain.environment.domain.Environment
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class QueryEnvironmentPersistenceAdapter(
    private val environmentMapper: EnvironmentMapper,
    private val environmentRepository: EnvironmentRepository
) : QueryEnvironmentPort {
    override fun findByIdOrNull(id: Long): Environment? {
        val environmentEntity = environmentRepository.findByIdOrNull(id)
        return environmentMapper toDomain environmentEntity
    }

    override fun findAll(): List<Environment> {
        val environmentList = environmentRepository.findAll()
        return environmentList.map { environmentMapper.toDomain(it)!! }
    }
}