package andreas311.miso.domain.environment.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.environment.adapter.input.data.request.CreateEnvironmentRequest
import andreas311.miso.domain.environment.adapter.input.mapper.EnvironmentDataMapper
import andreas311.miso.domain.environment.application.port.input.CreateEnvironmentUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/environment")
class EnvironmentAdapter(
    private val environmentDataMapper: EnvironmentDataMapper,
    private val createEnvironmentUseCase: CreateEnvironmentUseCase
) {
    @PostMapping
    fun create(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "environment") @Valid createEnvironmentRequest: CreateEnvironmentRequest
    ): ResponseEntity<Void> =
        createEnvironmentUseCase.execute(environmentDataMapper toDto createEnvironmentRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}