package andreas311.miso.domain.recyclables.adapter.input.mapper

import andreas311.miso.domain.recyclables.adapter.input.data.request.CreateRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.request.EditRecyclablesRequest
import andreas311.miso.domain.recyclables.application.port.input.dto.CreateRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.EditRecyclablesDto
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

    infix fun toDto(editRecyclablesRequest: EditRecyclablesRequest): EditRecyclablesDto =
        EditRecyclablesDto(
            title = editRecyclablesRequest.title,
            subTitle = editRecyclablesRequest.subTitle,
            recycleMethod = editRecyclablesRequest.recycleMethod,
            recycleTip = editRecyclablesRequest.recycleTip,
            recycleCaution = editRecyclablesRequest.recycleCaution,
            recyclablesType = editRecyclablesRequest.recyclablesType,
            recycleMark = editRecyclablesRequest.recycleMark
        )
}