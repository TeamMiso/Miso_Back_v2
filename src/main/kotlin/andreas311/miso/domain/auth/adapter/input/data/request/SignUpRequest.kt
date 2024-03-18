package andreas311.miso.domain.auth.adapter.input.data.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class SignUpRequest(
    @field:NotBlank
    val email: String,
    @field:NotBlank
    @field:Length(min = 8, max = 16)
    @field:Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*?~])[0-9a-zA-Z!@#$%^&*?~]+$")
    val password: String,
    @field:NotBlank
    val passwordCheck: String
)