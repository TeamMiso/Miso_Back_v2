package andreas311.miso.domain.item.application.port.input

interface DeleteItemUseCase {
    fun execute(id: Long)
}