package andreas311.miso.domain.email.application.port.output

import andreas311.miso.domain.email.domain.Email

interface CommandEmailPort {
    fun saveEmail(email: Email): Email
}