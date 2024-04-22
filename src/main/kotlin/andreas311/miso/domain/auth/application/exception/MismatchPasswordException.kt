package andreas311.miso.domain.auth.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class MismatchPasswordException : MisoException(ErrorCode.MISMATCH_PASSWORD)