package andreas311.miso.global.error.exception

import andreas311.miso.global.error.ErrorCode

open class MisoException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)