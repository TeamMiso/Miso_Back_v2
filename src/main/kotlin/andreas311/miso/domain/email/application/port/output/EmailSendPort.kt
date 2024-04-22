package andreas311.miso.domain.email.application.port.output

interface EmailSendPort {
    fun sendEmailAuthKey(email: String)
}