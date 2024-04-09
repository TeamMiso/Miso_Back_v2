package andreas311.miso.domain.environment.application.port.input

interface DeleteEnvironmentUseCase {
    fun execute(id: Long)
}