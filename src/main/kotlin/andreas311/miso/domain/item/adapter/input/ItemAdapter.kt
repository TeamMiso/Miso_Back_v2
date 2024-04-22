package andreas311.miso.domain.item.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.item.adapter.input.data.request.CreateItemRequest
import andreas311.miso.domain.item.adapter.input.data.request.EditItemRequest
import andreas311.miso.domain.item.adapter.input.data.response.DetailItemResponse
import andreas311.miso.domain.item.adapter.input.data.response.ListItemResponse
import andreas311.miso.domain.item.adapter.input.mapper.ItemDataMapper
import andreas311.miso.domain.item.application.port.input.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/item")
class ItemAdapter(
    private val itemDataMapper: ItemDataMapper,
    private val editItemUseCase: EditItemUseCase,
    private val listItemUseCase: ListItemUseCase,
    private val createItemUseCase: CreateItemUseCase,
    private val detailItemUseCase: DetailItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "item") @Valid createItemRequest: CreateItemRequest
    ): ResponseEntity<Void> =
        createItemUseCase.execute(itemDataMapper toDto createItemRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping()
    fun list(): ResponseEntity<ListItemResponse> =
        listItemUseCase.execute()
            .let { itemDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailItemResponse> =
        detailItemUseCase.execute(id)
            .let { itemDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @PatchMapping("/{id}")
    fun edit(
        @PathVariable id: Long,
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "item") @Valid editItemRequest: EditItemRequest
    ): ResponseEntity<Void> =
        editItemUseCase.execute(id, itemDataMapper toDto editItemRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        deleteItemUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }
}
