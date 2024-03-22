package andreas311.miso.domain.email.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.email.application.exception.EmailKeyInvalidException
import andreas311.miso.domain.email.application.port.input.RandomKeyConfirmUseCase
import andreas311.miso.domain.email.application.port.input.dto.RandomKeyDto
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.application.port.output.QueryEmailPort

@RollbackService
class RandomKeyConfirmService(
    private val commandEmailPort: CommandEmailPort,
    private val queryEmailPort: QueryEmailPort
) : RandomKeyConfirmUseCase {
    override fun execute(randomKeyDto: RandomKeyDto) {
        val email = queryEmailPort.findByRandomKeyOrNull(randomKeyDto.randomKey)
            ?: throw EmailKeyInvalidException()

        commandEmailPort.saveEmail(email.updateAuthentication(true))
    }
}