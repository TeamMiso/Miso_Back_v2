package andreas311.miso.thirdparty.aws.s3.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class InvalidFormatFileException: MisoException(ErrorCode.INVALID_FORMAT_FILE)