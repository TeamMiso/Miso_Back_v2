package andreas311.miso.global.security.jwt.common.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class TokenExpiredException : MisoException(ErrorCode.TOKEN_IS_EXPIRED) {
}