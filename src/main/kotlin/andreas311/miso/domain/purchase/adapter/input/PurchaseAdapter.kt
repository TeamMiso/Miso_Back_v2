package andreas311.miso.domain.purchase.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.purchase.application.port.input.PurchaseItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/purchase")
class PurchaseAdapter(
    private val purchaseItemUseCase: PurchaseItemUseCase
) {
    @PostMapping("/{id}")
    fun purchase(@PathVariable id: Long): ResponseEntity<Void> =
        purchaseItemUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}