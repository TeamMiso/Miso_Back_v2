package andreas311.miso.domain.recyclables.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.recyclables.adapter.input.data.request.CreateRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.data.request.EditRecyclablesRequest
import andreas311.miso.domain.recyclables.adapter.input.mapper.RecyclablesDataMapper
import andreas311.miso.domain.recyclables.application.port.input.CreateRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.DeleteRecyclablesUseCase
import andreas311.miso.domain.recyclables.application.port.input.EditRecyclablesUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/recyclables")
class RecyclablesAdapter(
    private val recyclablesDataMapper: RecyclablesDataMapper,
    private val editRecyclablesUseCase: EditRecyclablesUseCase,
    private val createRecyclablesUseCase: CreateRecyclablesUseCase,
    private val deleteRecyclablesUseCase: DeleteRecyclablesUseCase
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "recyclables") @Valid createRecyclablesRequest: CreateRecyclablesRequest
    ): ResponseEntity<Void> =
        createRecyclablesUseCase.execute(recyclablesDataMapper toDto createRecyclablesRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        deleteRecyclablesUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @PatchMapping("/{id}")
    fun edit(
        @PathVariable id: Long,
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "recyclables") @Valid editRecyclablesRequest: EditRecyclablesRequest
    ): ResponseEntity<Void> =
        editRecyclablesUseCase.execute(id, recyclablesDataMapper toDto editRecyclablesRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}