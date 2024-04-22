package andreas311.miso.domain.notification.application.scheduler

import andreas311.miso.domain.notification.application.port.input.EnvironmentNotificationSendUseCase
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class EnvironmentNotificationScheduler(
    private val environmentNotificationSendUseCase: EnvironmentNotificationSendUseCase
) {
    @Scheduled(cron = "0 0 13 * * ?")
    fun sendEnvironmentNotification() {
        environmentNotificationSendUseCase.execute()
    }
}