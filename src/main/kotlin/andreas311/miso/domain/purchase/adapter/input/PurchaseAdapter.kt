package andreas311.miso.domain.purchase.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.purchase.adapter.input.data.response.ListPurchaseResponse
import andreas311.miso.domain.purchase.adapter.input.mapper.PurchaseDataMapper
import andreas311.miso.domain.purchase.application.port.input.ListMyPurchaseItemUseCase
import andreas311.miso.domain.purchase.application.port.input.PurchaseItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/purchase")
class PurchaseAdapter(
    private val purchaseDataMapper: PurchaseDataMapper,
    private val purchaseItemUseCase: PurchaseItemUseCase,
    private val listMyPurchaseItemUseCase: ListMyPurchaseItemUseCase
) {
    @PostMapping("/{id}")
    fun purchase(@PathVariable id: Long): ResponseEntity<Void> =
        purchaseItemUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun myPurchase(): ResponseEntity<ListPurchaseResponse> =
        listMyPurchaseItemUseCase.execute()
            .let { purchaseDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}