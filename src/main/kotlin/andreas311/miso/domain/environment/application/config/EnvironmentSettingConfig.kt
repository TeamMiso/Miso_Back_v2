package andreas311.miso.domain.environment.application.config

import andreas311.miso.domain.environment.application.port.output.CommandTodayEnvironmentPort
import andreas311.miso.domain.environment.application.port.output.QueryEnvironmentPort
import andreas311.miso.domain.environment.domain.TodayEnvironment
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class EnvironmentSettingConfig(
    private val queryEnvironmentPort: QueryEnvironmentPort,
    private val commandTodayEnvironmentPort: CommandTodayEnvironmentPort
) {
    @PostConstruct
    fun environmentSetting() {
        val environment = queryEnvironmentPort.findAll().shuffled().first()

        commandTodayEnvironmentPort.deleteAllTodayEnvironment()

        commandTodayEnvironmentPort.saveTodayEnvironment(
            TodayEnvironment(
                id = 0L,
                title = environment.title,
                content = environment.content,
                imageUrl = environment.imageUrl
            )
        )
    }
}