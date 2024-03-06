package andreas311.miso.domain.auth.application.port.output

interface PasswordEncodePort {
    fun passwordEncode(password: String): String

    fun isPasswordMatch(password: String, passwordCheck: String): Boolean
}