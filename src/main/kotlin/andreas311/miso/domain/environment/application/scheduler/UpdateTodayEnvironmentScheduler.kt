package andreas311.miso.domain.environment.application.scheduler

import andreas311.miso.domain.environment.application.port.input.UpdateTodayEnvironmentUseCase
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class UpdateTodayEnvironmentScheduler(
    private val updateTodayEnvironmentUseCase: UpdateTodayEnvironmentUseCase
) {
    @Scheduled(cron = "0 0 0 * * ?")
    fun updateTodayEnvironment() {
        updateTodayEnvironmentUseCase.execute()
    }
}