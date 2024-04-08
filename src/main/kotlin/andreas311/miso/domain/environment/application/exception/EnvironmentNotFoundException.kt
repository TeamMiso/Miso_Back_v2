package andreas311.miso.domain.environment.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class EnvironmentNotFoundException : MisoException(ErrorCode.ENVIRONMENT_NOT_FOUND)