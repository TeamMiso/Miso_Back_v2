package andreas311.miso.domain.email.application.port.output

import andreas311.miso.domain.email.domain.Email

interface QueryEmailPort {
    fun findByEmailOrNull(email: String): Email?
    fun existsByEmail(email: String): Boolean
}