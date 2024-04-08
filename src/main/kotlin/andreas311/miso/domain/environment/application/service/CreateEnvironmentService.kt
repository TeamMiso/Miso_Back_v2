package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.environment.application.port.input.CreateEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.dto.CreateEnvironmentDto
import andreas311.miso.domain.environment.application.port.output.CommandEnvironmentPort
import andreas311.miso.domain.environment.domain.Environment
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.web.multipart.MultipartFile

@RollbackService
class CreateEnvironmentService(
    private val s3Util: S3Util,
    private val commandEnvironmentPort: CommandEnvironmentPort
) : CreateEnvironmentUseCase {
    override fun execute(createEnvironmentDto: CreateEnvironmentDto, multipartFile: MultipartFile?) {
        val imageUrl =
            if (multipartFile != null) {
                s3Util.execute(multipartFile)
            } else null

        commandEnvironmentPort.saveEnvironment(
            Environment(
                id = 0L,
                title = createEnvironmentDto.title,
                content = createEnvironmentDto.content,
                imageUrl = imageUrl
            )
        )
    }
}