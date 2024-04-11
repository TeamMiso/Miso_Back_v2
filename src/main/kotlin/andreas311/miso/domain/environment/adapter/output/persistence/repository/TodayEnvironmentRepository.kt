package andreas311.miso.domain.environment.adapter.output.persistence.repository

import andreas311.miso.domain.environment.adapter.output.persistence.entity.TodayEnvironmentEntity
import org.springframework.data.repository.CrudRepository

interface TodayEnvironmentRepository : CrudRepository<TodayEnvironmentEntity, Long>