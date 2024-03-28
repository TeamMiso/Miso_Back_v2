package andreas311.miso.domain.recyclables.adapter.input.mapper

import andreas311.miso.domain.recyclables.adapter.input.data.CreateRecyclablesRequest
import andreas311.miso.domain.recyclables.application.port.input.dto.CreateRecyclablesDto
import org.springframework.stereotype.Component

@Component
class RecyclablesDataMapper {
    infix fun toDto(createRecyclablesRequest: CreateRecyclablesRequest): CreateRecyclablesDto =
        CreateRecyclablesDto(
            title = createRecyclablesRequest.title,
            subTitle = createRecyclablesRequest.subTitle,
            recycleMethod = createRecyclablesRequest.recycleMethod,
            recycleTip = createRecyclablesRequest.recycleTip,
            recycleCaution = createRecyclablesRequest.recycleCaution,
            recyclablesType = createRecyclablesRequest.recyclablesType,
            recycleMark = createRecyclablesRequest.recycleMark
        )
}