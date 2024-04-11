package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.environment.application.port.input.UpdateTodayEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.output.QueryEnvironmentPort
import andreas311.miso.domain.environment.application.port.output.QueryTodayEnvironmentPort
import andreas311.miso.domain.environment.domain.Environment

@RollbackService
class UpdateTodayEnvironmentService(
    private val queryEnvironmentPort: QueryEnvironmentPort,
    private val queryTodayEnvironmentPort: QueryTodayEnvironmentPort
) : UpdateTodayEnvironmentUseCase {
    override fun execute() {
        val todayEnvironment = queryTodayEnvironmentPort.findOne()

        val environment = getRandomEnvironment(todayEnvironment.title)

        todayEnvironment.updateTodayEnvironment(environment)
    }

    private fun getRandomEnvironment(title: String): Environment {

        val environments = queryEnvironmentPort.findAll().filterNot { it.title == title }
        return environments.shuffled().first()
    }
}