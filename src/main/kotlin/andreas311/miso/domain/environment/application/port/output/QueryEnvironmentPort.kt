package andreas311.miso.domain.environment.application.port.output

import andreas311.miso.domain.environment.domain.Environment

interface QueryEnvironmentPort {
    fun findByIdOrNull(id: Long): Environment?
    fun findAll(): List<Environment>
}