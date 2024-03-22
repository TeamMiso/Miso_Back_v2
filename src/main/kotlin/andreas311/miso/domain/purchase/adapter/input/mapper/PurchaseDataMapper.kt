package andreas311.miso.domain.purchase.adapter.input.mapper

import andreas311.miso.domain.purchase.adapter.input.data.response.ListPurchaseResponse
import andreas311.miso.domain.purchase.adapter.input.data.response.PurchaseResponse
import andreas311.miso.domain.purchase.application.port.input.dto.ListPurchaseDto
import org.springframework.stereotype.Component

@Component
class PurchaseDataMapper {
    fun toResponse(listPurchaseDto: ListPurchaseDto): ListPurchaseResponse =
        ListPurchaseResponse(
            listPurchaseDto.purchaseList
                .map {
                    PurchaseResponse(
                        id = it.id,
                        price = it.price,
                        name = it.name,
                        imageUrl = it.imageUrl,
                        createdDate = it.createdDate
                    )
                }
        )
}