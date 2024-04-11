package andreas311.miso.domain.environment.adapter.output.persistence

import andreas311.miso.domain.environment.adapter.output.persistence.mapper.TodayEnvironmentMapper
import andreas311.miso.domain.environment.adapter.output.persistence.repository.TodayEnvironmentRepository
import andreas311.miso.domain.environment.application.port.output.CommandTodayEnvironmentPort
import andreas311.miso.domain.environment.domain.TodayEnvironment
import org.springframework.stereotype.Component

@Component
class CommandTodayEnvironmentPersistenceAdapter(
    private val todayEnvironmentMapper: TodayEnvironmentMapper,
    private val todayEnvironmentRepository: TodayEnvironmentRepository
) : CommandTodayEnvironmentPort {
    override fun saveTodayEnvironment(todayEnvironment: TodayEnvironment): TodayEnvironment {
        val environmentEntity = todayEnvironmentRepository.save(todayEnvironmentMapper toEntity todayEnvironment)
        return todayEnvironmentMapper.toDomain(environmentEntity)!!
    }

    override fun deleteAllTodayEnvironment() {
        return todayEnvironmentRepository.deleteAll()
    }
}