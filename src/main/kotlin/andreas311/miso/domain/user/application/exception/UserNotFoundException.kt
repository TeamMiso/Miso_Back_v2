package andreas311.miso.domain.user.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class UserNotFoundException: MisoException(ErrorCode.USER_NOT_FOUND)