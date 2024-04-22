package andreas311.miso.global.security.jwt.common.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class TokenInvalidException : MisoException(ErrorCode.TOKEN_NOT_VALID) {
}