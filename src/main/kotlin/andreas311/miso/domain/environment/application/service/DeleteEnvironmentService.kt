package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.environment.application.exception.EnvironmentNotFoundException
import andreas311.miso.domain.environment.application.port.input.DeleteEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.output.CommandEnvironmentPort
import andreas311.miso.domain.environment.application.port.output.QueryEnvironmentPort

@RollbackService
class DeleteEnvironmentService(
    private val queryEnvironmentPort: QueryEnvironmentPort,
    private val commandEnvironmentPort: CommandEnvironmentPort
) : DeleteEnvironmentUseCase {
    override fun execute(id: Long) {
        val environment = queryEnvironmentPort.findByIdOrNull(id)
            ?: throw EnvironmentNotFoundException()

        commandEnvironmentPort.deleteEnvironment(environment)
    }
}