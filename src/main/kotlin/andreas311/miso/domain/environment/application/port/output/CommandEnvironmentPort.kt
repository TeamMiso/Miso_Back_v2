package andreas311.miso.domain.environment.application.port.output

import andreas311.miso.domain.environment.domain.Environment

interface CommandEnvironmentPort {
    fun saveEnvironment(environment: Environment): Environment
    fun deleteEnvironment(environment: Environment)
}