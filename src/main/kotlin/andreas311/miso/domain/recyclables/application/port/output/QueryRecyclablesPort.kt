package andreas311.miso.domain.recyclables.application.port.output

import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.domain.recyclables.domain.RecyclablesType

interface QueryRecyclablesPort {
    fun findByIdOrNull(id: Long): Recyclables?
    fun findByRecyclablesTypeOrNull(recyclablesType: RecyclablesType): Recyclables?
    fun findAll(): List<Recyclables>
    fun search(searchValue: String): Recyclables?
}