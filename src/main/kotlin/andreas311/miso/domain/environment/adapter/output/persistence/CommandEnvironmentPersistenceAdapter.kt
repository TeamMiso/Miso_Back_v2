package andreas311.miso.domain.environment.adapter.output.persistence

import andreas311.miso.domain.environment.adapter.output.persistence.mapper.EnvironmentMapper
import andreas311.miso.domain.environment.adapter.output.persistence.repository.EnvironmentRepository
import andreas311.miso.domain.environment.application.port.output.CommandEnvironmentPort
import andreas311.miso.domain.environment.domain.Environment
import org.springframework.stereotype.Component

@Component
class CommandEnvironmentPersistenceAdapter(
    private val environmentMapper: EnvironmentMapper,
    private val environmentRepository: EnvironmentRepository
) : CommandEnvironmentPort {
    override fun saveEnvironment(environment: Environment): Environment {
        val environmentEntity = environmentRepository.save(environmentMapper toEntity environment)
        return environmentMapper.toDomain(environmentEntity)!!
    }
}