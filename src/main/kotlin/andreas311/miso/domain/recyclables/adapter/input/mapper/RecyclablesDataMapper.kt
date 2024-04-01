package andreas311.miso.domain.recyclables.adapter.input.mapper

import andreas311.miso.domain.recyclables.adapter.input.data.request.CreateRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.request.EditRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.response.DetailRecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.data.response.ListRecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.data.response.RecyclablesResponse
import andreas311.miso.domain.recyclables.application.port.input.dto.CreateRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.DetailRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.EditRecyclablesDto
import andreas311.miso.domain.recyclables.application.port.input.dto.ListRecyclablesDto
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

    fun toResponse(detailRecyclablesDto: DetailRecyclablesDto): DetailRecyclablesResponse =
        DetailRecyclablesResponse(
            id = detailRecyclablesDto.id,
            title = detailRecyclablesDto.title,
            subTitle = detailRecyclablesDto.subTitle,
            recycleMethod = detailRecyclablesDto.recycleMethod,
            recycleTip = detailRecyclablesDto.recycleTip,
            recycleCaution = detailRecyclablesDto.recycleCaution,
            imageUrl = detailRecyclablesDto.imageUrl,
            recyclablesType = detailRecyclablesDto.recyclablesType,
            recycleMark = detailRecyclablesDto.recycleMark
        )

    fun toResponse(listRecyclablesDto: ListRecyclablesDto): ListRecyclablesResponse =
        ListRecyclablesResponse(
            listRecyclablesDto.recyclablesList
                .map {
                    RecyclablesResponse(
                        title = it.title,
                        imageUrl = it.imageUrl,
                        recycleMethod = it.recycleMethod,
                        recyclablesType = it.recyclablesType
                    )
                }
        )
}