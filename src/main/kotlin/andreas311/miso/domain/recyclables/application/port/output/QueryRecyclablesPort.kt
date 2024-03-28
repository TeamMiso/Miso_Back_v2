package andreas311.miso.domain.recyclables.application.port.output

import andreas311.miso.domain.recyclables.domain.Recyclables

interface QueryRecyclablesPort {
    fun findByIdOrNull(id: Long): Recyclables?
}