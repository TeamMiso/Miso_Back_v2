package andreas311.miso.global.security.adapter

import andreas311.miso.domain.auth.application.exception.MismatchPasswordException
import andreas311.miso.domain.auth.application.port.output.PasswordEncodePort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncodeAdapter(
    private val passwordEncoder: PasswordEncoder
): PasswordEncodePort {
    override fun passwordEncode(password: String): String =
        passwordEncoder.encode(password)

    override fun isPasswordMatch(password: String, passwordCheck: String) {
        if (password != passwordCheck) {
            throw MismatchPasswordException()
        }
    }
}