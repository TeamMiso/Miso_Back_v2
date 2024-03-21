package andreas311.miso.domain.purchase.application.exception

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.exception.MisoException

class ItemSoldOutException : MisoException(ErrorCode.ITEM_IS_SOLD_OUT)