package andreas311.miso.domain.item.application.service

import andreas311.miso.domain.item.application.exception.ItemNotFoundException
import andreas311.miso.domain.item.application.port.input.EditItemUseCase
import andreas311.miso.domain.item.application.port.input.dto.EditItemDto
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import andreas311.miso.domain.item.domain.Item
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class EditItemService(
    private val s3Util: S3Util,
    private val queryItemPort: QueryItemPort,
    private val commandItemPort: CommandItemPort
) : EditItemUseCase {
    override fun execute(id: Long, editItemDto: EditItemDto, multipartFile: MultipartFile?) {
        val item = queryItemPort.findByIdOrNull(id)
            ?: throw ItemNotFoundException()

        val imageUrl = multipartFile?.let {
            s3Util.execute(it)
        } ?: item.imageUrl

        commandItemPort.saveItem(
            Item(
                id = item.id,
                price = editItemDto.price,
                amount = editItemDto.amount,
                name = editItemDto.name,
                content = editItemDto.content,
                imageUrl = imageUrl
            )
        )
    }
}