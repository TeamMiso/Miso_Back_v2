package andreas311.miso.domain.recyclables.adapter.output.persistence.repository

import andreas311.miso.domain.recyclables.adapter.output.persistence.entity.RecyclablesEntity
import andreas311.miso.domain.recyclables.domain.RecyclablesType
import org.springframework.data.repository.CrudRepository

interface RecyclablesRepository : CrudRepository<RecyclablesEntity, Long> {
    fun findByRecyclablesType(recyclablesType: RecyclablesType): RecyclablesEntity?
}