package andreas311.miso.domain.auth.application.port.input.dto

data class SignUpDto(
    val email: String,
    val password: String,
    val passwordCheck: String
)
