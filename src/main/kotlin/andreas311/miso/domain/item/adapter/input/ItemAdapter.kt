package andreas311.miso.domain.item.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.item.adapter.input.data.request.CreateItemRequest
import andreas311.miso.domain.item.adapter.input.data.request.EditItemRequest
import andreas311.miso.domain.item.adapter.input.mapper.ItemDataMapper
import andreas311.miso.domain.item.application.port.input.CreateItemUseCase
import andreas311.miso.domain.item.application.port.input.EditItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RequestController("/item")
class ItemAdapter(
    private val itemDataMapper: ItemDataMapper,
    private val editItemUseCase: EditItemUseCase,
    private val createItemUseCase: CreateItemUseCase,
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "item") createItemRequest: CreateItemRequest
    ): ResponseEntity<Void> =
        createItemUseCase.execute(itemDataMapper toDto createItemRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PatchMapping("/{id}")
    fun edit (
        @PathVariable id: Long,
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "item") editItemRequest: EditItemRequest
    ): ResponseEntity<Void> =
        editItemUseCase.execute(id, itemDataMapper toDto editItemRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}