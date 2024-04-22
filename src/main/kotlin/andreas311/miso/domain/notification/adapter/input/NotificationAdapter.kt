package andreas311.miso.domain.notification.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.notification.adapter.input.data.DetailNotificationResponse
import andreas311.miso.domain.notification.adapter.input.mapper.NotificationDataMapper
import andreas311.miso.domain.notification.application.port.input.DetailNotificationUseCase
import andreas311.miso.domain.notification.application.port.input.SaveDeviceTokenUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/notification")
class NotificationAdapter(
    private val notificationDataMapper: NotificationDataMapper,
    private val saveDeviceTokenUseCase: SaveDeviceTokenUseCase,
    private val detailNotificationUseCase: DetailNotificationUseCase,
) {
    @PostMapping("/save/{token}")
    fun save(@PathVariable(name = "token") deviceToken: String): ResponseEntity<Void> =
        saveDeviceTokenUseCase.execute(deviceToken)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailNotificationResponse> =
        detailNotificationUseCase.execute(id)
            .let { notificationDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}