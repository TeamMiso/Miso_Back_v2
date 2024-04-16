package andreas311.miso.domain.recyclables.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.recyclables.adapter.input.data.request.CreateRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.request.EditRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.response.DetailRecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.data.response.ListDetailRecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.data.response.ListRecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.data.response.RecyclablesResponse
import andreas311.miso.domain.recyclables.adapter.input.mapper.RecyclablesDataMapper
import andreas311.miso.domain.recyclables.application.port.input.*
import andreas311.miso.domain.recyclables.domain.RecyclablesType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/recyclables")
class RecyclablesAdapter(
    private val recyclablesDataMapper: RecyclablesDataMapper,
    private val listRecyclablesUseCase: ListRecyclablesUseCase,
    private val editRecyclablesUseCase: EditRecyclablesUseCase,
    private val createRecyclablesUseCase: CreateRecyclablesUseCase,
    private val searchRecyclablesUseCase: SearchRecyclablesUseCase,
    private val detailRecyclablesUseCase: DetailRecyclablesUseCase,
    private val deleteRecyclablesUseCase: DeleteRecyclablesUseCase,
    private val processRecyclablesUseCase: ProcessRecyclablesUseCase
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "recyclables") @Valid createRecyclablesRequest: CreateRecyclablesRequest
    ): ResponseEntity<Void> =
        createRecyclablesUseCase.execute(recyclablesDataMapper toDto createRecyclablesRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/process")
    fun process(@RequestPart(value = "recyclables") multipartFile: MultipartFile): ResponseEntity<ListDetailRecyclablesResponse> =
        processRecyclablesUseCase.execute(multipartFile)
            .let { recyclablesDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/{type}")
    fun detail(@PathVariable(name = "type") recyclablesType: RecyclablesType): ResponseEntity<DetailRecyclablesResponse> =
        detailRecyclablesUseCase.execute(recyclablesType)
            .let { recyclablesDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/search")
    fun detail(@RequestParam searchValue: String): ResponseEntity<RecyclablesResponse> =
        searchRecyclablesUseCase.execute(searchValue)
            .let { recyclablesDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping
    fun list(): ResponseEntity<ListRecyclablesResponse> =
        listRecyclablesUseCase.execute()
            .let { recyclablesDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @PatchMapping("/{id}")
    fun edit(
        @PathVariable id: Long,
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "recyclables") @Valid editRecyclablesRequest: EditRecyclablesRequest
    ): ResponseEntity<Void> =
        editRecyclablesUseCase.execute(id, recyclablesDataMapper toDto editRecyclablesRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        deleteRecyclablesUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).build() }

}