package andreas311.miso.domain.recyclables.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class RecyclablesNotFoundException : MisoException(ErrorCode.RECYCLABLES_NOT_FOUND)