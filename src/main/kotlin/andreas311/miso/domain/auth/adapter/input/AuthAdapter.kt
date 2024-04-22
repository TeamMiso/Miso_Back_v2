package andreas311.miso.domain.auth.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.auth.adapter.input.data.request.SignInRequest
import andreas311.miso.domain.auth.adapter.input.data.request.SignUpRequest
import andreas311.miso.domain.auth.adapter.input.data.response.TokenResponse
import andreas311.miso.domain.auth.adapter.input.mapper.AuthDataMapper
import andreas311.miso.domain.auth.application.port.input.LogoutUseCase
import andreas311.miso.domain.auth.application.port.input.SignInUseCase
import andreas311.miso.domain.auth.application.port.input.SignUpUseCase
import andreas311.miso.domain.auth.application.port.input.TokenReissueUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestController("/auth")
class AuthAdapter(
    private val authDataMapper: AuthDataMapper,
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val tokenReissueUseCase: TokenReissueUseCase
) {
    @PostMapping
    fun signUp(@RequestBody @Valid signUpRequest: SignUpRequest): ResponseEntity<Void> =
        signUpUseCase.execute(authDataMapper toDto signUpRequest)
            .run { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/signIn")
    fun signIn(@RequestBody @Valid signInRequest: SignInRequest): ResponseEntity<TokenResponse> =
        signInUseCase.execute(authDataMapper toDto signInRequest)
            .let { authDataMapper toResponse it }
            .let { ResponseEntity.ok(it) }

    @DeleteMapping
    fun logout(): ResponseEntity<Void> =
        logoutUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.NO_CONTENT).build() }

    @PatchMapping
    fun reissue(@RequestHeader("Refresh-Token") refreshToken: String): ResponseEntity<TokenResponse> =
        tokenReissueUseCase.execute(refreshToken)
            .let { authDataMapper toResponse it }
            .let { ResponseEntity.ok(it) }
}