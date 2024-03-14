package andreas311.miso.domain.auth.adapter.input.data.request

import javax.validation.constraints.NotBlank

data class SignUpRequest(
    @field:NotBlank
    val email: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val passwordCheck: String
)