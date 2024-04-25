package andreas311.miso.domain.notification.application.port.input.dto

import andreas311.miso.domain.notification.domain.Notification

data class DetailNotificationDto(
    val answer: String
) {
    constructor(notification: Notification) : this(
        answer = notification.answer
    )

    constructor() : this(
        answer = ""
    )
}
