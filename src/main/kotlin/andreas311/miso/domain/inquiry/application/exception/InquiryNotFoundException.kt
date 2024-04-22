package andreas311.miso.domain.inquiry.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class InquiryNotFoundException : MisoException(ErrorCode.INQUIRY_LOG_NOT_FOUND)