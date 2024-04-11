package andreas311.miso.domain.environment.adapter.output.persistence

import andreas311.miso.domain.environment.adapter.output.persistence.mapper.TodayEnvironmentMapper
import andreas311.miso.domain.environment.adapter.output.persistence.repository.TodayEnvironmentRepository
import andreas311.miso.domain.environment.application.port.output.QueryTodayEnvironmentPort
import andreas311.miso.domain.environment.domain.TodayEnvironment
import org.springframework.stereotype.Component

@Component
class QueryTodayEnvironmentPersistenceAdapter(
    private val todayEnvironmentMapper: TodayEnvironmentMapper,
    private val todayEnvironmentRepository: TodayEnvironmentRepository
) : QueryTodayEnvironmentPort {
    override fun findAll(): List<TodayEnvironment> {
        val todayEnvironmentList = todayEnvironmentRepository.findAll()
        return todayEnvironmentList.map { todayEnvironmentMapper.toDomain(it)!! }
    }
}