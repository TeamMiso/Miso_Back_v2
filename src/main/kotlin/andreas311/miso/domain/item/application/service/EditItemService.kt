package andreas311.miso.domain.item.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.item.application.exception.ItemNotFoundException
import andreas311.miso.domain.item.application.port.input.EditItemUseCase
import andreas311.miso.domain.item.application.port.input.dto.EditItemDto
import andreas311.miso.domain.item.application.port.output.CommandItemPort
import andreas311.miso.domain.item.application.port.output.QueryItemPort
import andreas311.miso.domain.item.domain.Item
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Caching
import org.springframework.web.multipart.MultipartFile

@RollbackService
class EditItemService(
    private val s3Util: S3Util,
    private val queryItemPort: QueryItemPort,
    private val commandItemPort: CommandItemPort
) : EditItemUseCase {
    @Caching(evict = [
        CacheEvict(cacheNames = ["item"], key = "#id", cacheManager = "redisCacheManager"),
        CacheEvict(cacheNames = ["itemList"], key = "'itemList'", cacheManager = "redisCacheManager")
    ])
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