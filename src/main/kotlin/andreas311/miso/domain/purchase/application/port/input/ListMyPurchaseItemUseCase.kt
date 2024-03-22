package andreas311.miso.domain.purchase.application.port.input

import andreas311.miso.domain.purchase.application.port.input.dto.ListPurchaseDto

interface ListMyPurchaseItemUseCase {
    fun execute(): ListPurchaseDto
}