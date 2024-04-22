package andreas311.miso.domain.email.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class EmailSendFailedException: MisoException(ErrorCode.EMAIL_SEND_FAIL)