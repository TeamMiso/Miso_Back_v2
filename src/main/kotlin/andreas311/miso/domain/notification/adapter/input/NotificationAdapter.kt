package andreas311.miso.domain.notification.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.notification.adapter.input.data.DetailNotificationResponse
import andreas311.miso.domain.notification.adapter.input.mapper.NotificationDataMapper
import andreas311.miso.domain.notification.application.port.input.DetailNotificationUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RequestController("/notification")
class NotificationAdapter(
    private val notificationDataMapper: NotificationDataMapper,
    private val detailNotificationUseCase: DetailNotificationUseCase
) {
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailNotificationResponse> =
        detailNotificationUseCase.execute(id)
            .let { notificationDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}