package andreas311.miso.domain.purchase.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class PointNotEnoughException : MisoException(ErrorCode.POINT_IS_NOT_ENOUGH)