package andreas311.miso.domain.notification.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class NotificationNotFoundException : MisoException(ErrorCode.NOTIFICATION_NOT_FOUND)