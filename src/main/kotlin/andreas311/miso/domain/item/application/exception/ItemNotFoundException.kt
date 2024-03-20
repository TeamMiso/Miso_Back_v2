package andreas311.miso.domain.item.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class ItemNotFoundException : MisoException(ErrorCode.ITEM_NOT_FOUND)