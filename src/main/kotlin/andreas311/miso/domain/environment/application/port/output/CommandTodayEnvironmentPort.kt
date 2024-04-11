package andreas311.miso.domain.environment.application.port.output

import andreas311.miso.domain.environment.domain.TodayEnvironment

interface CommandTodayEnvironmentPort {
    fun saveTodayEnvironment(todayEnvironment: TodayEnvironment): TodayEnvironment
    fun deleteAllTodayEnvironment()
}