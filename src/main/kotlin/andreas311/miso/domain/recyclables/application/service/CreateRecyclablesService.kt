package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.recyclables.application.port.input.CreateRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.CreateRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.CommandRecyclablesPort
import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.web.multipart.MultipartFile

@RollbackService
class CreateRecyclablesService(
    private val s3Util: S3Util,
    private val commandRecyclablesPort: CommandRecyclablesPort
) : CreateRecyclablesUseCase {
    override fun execute(createRecyclablesDto: CreateRecyclablesDto, multipartFile: MultipartFile?) {
        val imageUrl =
            if (multipartFile != null) {
                s3Util.execute(multipartFile)
            } else null

        commandRecyclablesPort.saveRecyclables(
            Recyclables(
                id = 0L,
                title = createRecyclablesDto.title,
                subTitle = createRecyclablesDto.subTitle,
                recycleMethod = createRecyclablesDto.recycleMethod,
                recycleTip = createRecyclablesDto.recycleTip,
                recycleCaution = createRecyclablesDto.recycleCaution,
                imageUrl = imageUrl,
                recyclablesType = createRecyclablesDto.recyclablesType,
                recycleMark = createRecyclablesDto.recycleMark
            )
        )
    }
}