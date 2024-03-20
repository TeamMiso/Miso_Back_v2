package andreas311.miso.domain.item.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.item.application.port.input.CreateItemUseCase
import andreas311.miso.domain.item.application.port.input.dto.CreateItemDto
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.domain.Item
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.web.multipart.MultipartFile

@RollbackService
class CreateItemService(
    private val s3Util: S3Util,
    private val commandItemPort: CommandItemPort
) : CreateItemUseCase {
    override fun execute(createItemDto: CreateItemDto, multipartFile: MultipartFile?) {
        val imageUrl =
            if (multipartFile != null) {
                s3Util.execute(multipartFile)
            } else null

        commandItemPort.saveItem(
            Item(
                id = 0L,
                price = createItemDto.price,
                amount = createItemDto.amount,
                name = createItemDto.name,
                content = createItemDto.content,
                imageUrl = imageUrl
            )
        )
    }
}