package andreas311.miso.domain.item.adapter.input.mapper

import andreas311.miso.domain.item.adapter.input.data.request.CreateItemRequest
import andreas311.miso.domain.item.adapter.input.data.request.EditItemRequest
import andreas311.miso.domain.item.application.port.input.dto.CreateItemDto
import andreas311.miso.domain.item.application.port.input.dto.EditItemDto
import org.springframework.stereotype.Component

@Component
class ItemDataMapper {
    infix fun toDto(createItemRequest: CreateItemRequest): CreateItemDto =
        CreateItemDto(
            price = createItemRequest.price,
            amount = createItemRequest.amount,
            name = createItemRequest.name,
            content = createItemRequest.content
        )

    infix fun toDto(editItemRequest: EditItemRequest): EditItemDto =
        EditItemDto(
            price = editItemRequest.price,
            amount = editItemRequest.amount,
            name = editItemRequest.name,
            content = editItemRequest.content
        )
}