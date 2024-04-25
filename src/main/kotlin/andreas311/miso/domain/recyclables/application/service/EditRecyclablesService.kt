package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.recyclables.application.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.application.port.input.EditRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.EditRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.CommandRecyclablesPort
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import andreas311.miso.domain.recyclables.domain.Recyclables
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Caching
import org.springframework.web.multipart.MultipartFile

@RollbackService
class EditRecyclablesService(
    private val s3Util: S3Util,
    private val queryRecyclablesPort: QueryRecyclablesPort,
    private val commandRecyclablesPort: CommandRecyclablesPort
) : EditRecyclablesUseCase {
    @Caching(evict = [
        CacheEvict(cacheNames = ["recyclables"], key = "#editRecyclablesDto.recyclablesType", cacheManager = "redisCacheManager"),
        CacheEvict(cacheNames = ["recyclablesList"], key = "'recyclablesList'", cacheManager = "redisCacheManager")
    ])
    override fun execute(id: Long, editRecyclablesDto: EditRecyclablesDto, multipartFile: MultipartFile?) {
        val recyclables = queryRecyclablesPort.findByIdOrNull(id)
            ?: throw RecyclablesNotFoundException()

        val imageUrl = multipartFile?.let {
            s3Util.execute(it)
        } ?: recyclables.imageUrl

        commandRecyclablesPort.saveRecyclables(
            Recyclables(
                id = recyclables.id,
                title = editRecyclablesDto.title,
                subTitle = editRecyclablesDto.subTitle,
                recycleMethod = editRecyclablesDto.recycleMethod,
                recycleTip = editRecyclablesDto.recycleTip,
                recycleCaution = editRecyclablesDto.recycleCaution,
                imageUrl = imageUrl,
                recyclablesType = editRecyclablesDto.recyclablesType,
                recycleMark = editRecyclablesDto.recycleMark
            )
        )
    }
}