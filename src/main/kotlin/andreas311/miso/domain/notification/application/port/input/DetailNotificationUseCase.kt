package andreas311.miso.domain.notification.application.port.input

import andreas311.miso.domain.notification.application.port.input.dto.DetailNotificationDto

interface DetailNotificationUseCase {
    fun execute(id: Long): DetailNotificationDto
}