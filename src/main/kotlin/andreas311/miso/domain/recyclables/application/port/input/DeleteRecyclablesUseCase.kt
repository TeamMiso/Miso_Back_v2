package andreas311.miso.domain.recyclables.application.port.input

interface DeleteRecyclablesUseCase {
    fun execute(id: Long)
}