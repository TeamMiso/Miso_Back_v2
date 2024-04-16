package andreas311.miso.domain.recyclables.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.recyclables.application.exception.RecyclablesNotFoundException
import andreas311.miso.domain.recyclables.application.port.input.ProcessRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.dto.DetailRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.ListDetailRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.output.QueryRecyclablesPort
import andreas311.miso.domain.recyclables.domain.RecyclablesType
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.reactive.function.client.WebClient

@ReadOnlyRollbackService
class ProcessRecyclablesService(
    private val s3Util: S3Util,
    private val webClient: WebClient,
    private val queryRecyclablesPort: QueryRecyclablesPort
) : ProcessRecyclablesUseCase {

    @Value("\${ai.url}")
    private val url: String = ""

    override fun execute(multipartFile: MultipartFile): ListDetailRecyclablesDto {
        val resultList = webClient.post()
            .uri(url)
            .bodyValue(s3Util.execute(multipartFile))
            .retrieve()
            .bodyToMono(List::class.java)
            .map { it as List<String> }
            .block() ?: throw RecyclablesNotFoundException()

        val detailRecyclablesList = resultList.map { recyclablesType ->
            queryRecyclablesPort.findByRecyclablesTypeOrNull(RecyclablesType.valueOf(recyclablesType))
        }

        val recyclablesList = detailRecyclablesList.filterNotNull().map { DetailRecyclablesDto(it) }

        return ListDetailRecyclablesDto(recyclablesList)
    }
}