package andreas311.miso.domain.environment.application.port.output

import andreas311.miso.domain.environment.domain.TodayEnvironment

interface QueryTodayEnvironmentPort {
    fun findAll(): List<TodayEnvironment>
}