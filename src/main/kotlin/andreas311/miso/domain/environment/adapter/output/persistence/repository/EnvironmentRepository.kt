package andreas311.miso.domain.environment.adapter.output.persistence.repository

import andreas311.miso.domain.environment.adapter.output.persistence.entity.EnvironmentEntity
import org.springframework.data.repository.CrudRepository

interface EnvironmentRepository : CrudRepository<EnvironmentEntity, Long>