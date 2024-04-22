package andreas311.miso.domain.purchase.application.port.input

interface PurchaseItemUseCase {
    fun execute(id: Long)
}