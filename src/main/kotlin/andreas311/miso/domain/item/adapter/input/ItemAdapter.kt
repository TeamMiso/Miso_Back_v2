package andreas311.miso.domain.item.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.item.adapter.input.data.request.CreateItemRequest
import andreas311.miso.domain.item.adapter.input.mapper.ItemDataMapper
import andreas311.miso.domain.item.application.port.input.CreateItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@RequestController("/item")
class ItemAdapter(
    private val itemDataMapper: ItemDataMapper,
    private val createItemUseCase: CreateItemUseCase
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "item") createItemRequest: CreateItemRequest
    ): ResponseEntity<Void> =
        createItemUseCase.execute(itemDataMapper toDto createItemRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}