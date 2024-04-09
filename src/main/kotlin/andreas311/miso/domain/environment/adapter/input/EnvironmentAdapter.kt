package andreas311.miso.domain.environment.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.environment.adapter.input.data.request.CreateEnvironmentRequest
import andreas311.miso.domain.environment.adapter.input.data.request.EditEnvironmentRequest
import andreas311.miso.domain.environment.adapter.input.mapper.EnvironmentDataMapper
import andreas311.miso.domain.environment.application.port.input.CreateEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.DeleteEnvironmentUseCase
import andreas311.miso.domain.environment.application.port.input.EditEnvironmentUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/environment")
class EnvironmentAdapter(
    private val environmentDataMapper: EnvironmentDataMapper,
    private val editEnvironmentUseCase: EditEnvironmentUseCase,
    private val createEnvironmentUseCase: CreateEnvironmentUseCase,
    private val deleteEnvironmentUseCase: DeleteEnvironmentUseCase
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "environment") @Valid createEnvironmentRequest: CreateEnvironmentRequest
    ): ResponseEntity<Void> =
        createEnvironmentUseCase.execute(environmentDataMapper toDto createEnvironmentRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PatchMapping("/{id}")
    fun edit(
        @PathVariable id: Long,
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "environment") @Valid editEnvironmentRequest: EditEnvironmentRequest
    ): ResponseEntity<Void> =
        editEnvironmentUseCase.execute(id, environmentDataMapper toDto editEnvironmentRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        deleteEnvironmentUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}