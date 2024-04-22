package andreas311.miso.domain.environment.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.environment.application.exception.EnvironmentNotFoundException
import andreas311.miso.domain.environment.application.port.input.EditEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.dto.EditEnvironmentDto
import andreas311.miso.domain.environment.application.port.output.CommandEnvironmentPort
import andreas311.miso.domain.environment.application.port.output.QueryEnvironmentPort
import andreas311.miso.domain.environment.domain.Environment
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.web.multipart.MultipartFile

@RollbackService
class EditEnvironmentService(
    private val s3Util: S3Util,
    private val queryEnvironmentPort: QueryEnvironmentPort,
    private val commandEnvironmentPort: CommandEnvironmentPort
) : EditEnvironmentUseCase {
    override fun execute(id: Long, editEnvironmentDto: EditEnvironmentDto, multipartFile: MultipartFile?) {
        val environment = queryEnvironmentPort.findByIdOrNull(id)
            ?: throw EnvironmentNotFoundException()

        val imageUrl = multipartFile?.let {
            s3Util.execute(it)
        } ?: environment.imageUrl

        commandEnvironmentPort.saveEnvironment(
            Environment(
                id = environment.id,
                title = editEnvironmentDto.title,
                content = editEnvironmentDto.content,
                imageUrl = imageUrl
            )
        )
    }
}