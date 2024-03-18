package andreas311.miso.domain.auth.application.event

import andreas311.miso.domain.auth.application.port.output.CommandRefreshTokenPort
import andreas311.miso.domain.auth.domain.RefreshToken
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class SaveRefreshTokenEventHandler(
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) {
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun saveRefreshToken(saveRefreshTokenEvent: SaveRefreshTokenEvent) {
        log.info("saveRefreshTokenEvent is activate")

        val refreshToken = RefreshToken(
            userId = saveRefreshTokenEvent.userId,
            refreshToken = saveRefreshTokenEvent.refreshToken
        )
        commandRefreshTokenPort.saveRefreshToken(refreshToken)
    }
}