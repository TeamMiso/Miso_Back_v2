package andreas311.miso.domain.email.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.email.adapter.input.data.request.RandomKeyRequest
import andreas311.miso.domain.email.adapter.input.mapper.EmailDataMapper
import andreas311.miso.domain.email.application.port.input.RandomKeyConfirmUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RequestController("/email")
class EmailAdapter(
    private val emailDataMapper: EmailDataMapper,
    private val randomKeyConfirmUseCase: RandomKeyConfirmUseCase
) {
    @PostMapping
    fun emailCheck(@RequestBody @Valid randomKeyRequest: RandomKeyRequest): ResponseEntity<Void> =
        randomKeyConfirmUseCase.execute(emailDataMapper toDto randomKeyRequest)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}