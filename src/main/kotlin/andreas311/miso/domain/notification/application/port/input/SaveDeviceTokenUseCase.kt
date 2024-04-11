package andreas311.miso.domain.notification.application.port.input

interface SaveDeviceTokenUseCase {
    fun execute(token: String)
}