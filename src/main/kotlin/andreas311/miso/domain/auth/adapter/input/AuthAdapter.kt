package andreas311.miso.domain.auth.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.auth.adapter.input.data.request.SignUpRequest
import andreas311.miso.domain.auth.adapter.input.mapper.AuthDataMapper
import andreas311.miso.domain.auth.application.port.input.SignUpUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RequestController("/auth")
class AuthAdapter(
    private val authDataMapper: AuthDataMapper,
    private val signUpUseCase: SignUpUseCase
) {
    @PostMapping
    fun signUp(@RequestBody @Valid signUpRequest: SignUpRequest): ResponseEntity<Void> =
        signUpUseCase.execute(authDataMapper toDto signUpRequest)
            .run { ResponseEntity.status(HttpStatus.CREATED).build() }

}