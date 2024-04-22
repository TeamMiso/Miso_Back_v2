package andreas311.miso.domain.inquiry.application.service

import andreas311.miso.common.annotation.RollbackService
import andreas311.miso.domain.auth.application.port.output.UserSecurityPort
import andreas311.miso.domain.inquiry.application.port.input.WriteInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryDto
import andreas311.miso.domain.inquiry.application.port.output.CommandInquiryPort
import andreas311.miso.domain.inquiry.application.port.output.DiscordMessageSendPort
import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.notification.application.port.input.InquiryNotificationSendUseCase
import andreas311.miso.domain.notification.application.port.output.QueryDeviceTokenPort
import andreas311.miso.thirdparty.aws.s3.util.S3Util
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@RollbackService
class WriteInquiryService(
    private val s3Util: S3Util,
    private val userSecurityPort: UserSecurityPort,
    private val commandInquiryPort: CommandInquiryPort,
    private val queryDeviceTokenPort: QueryDeviceTokenPort,
    private val discordMessageSendPort: DiscordMessageSendPort,
    private val inquiryNotificationSendUseCase: InquiryNotificationSendUseCase
) : WriteInquiryUseCase {
    override fun execute(writeInquiryDto: WriteInquiryDto, multipartFile: MultipartFile?) {
        val user = userSecurityPort.currentUser()

        val imageUrl =
            if (multipartFile != null) {
                s3Util.execute(multipartFile)
            } else null

        val deviceToken = queryDeviceTokenPort.findByUserIdOrNull(user.id)

        val inquiry = Inquiry(
                id = 0L,
                title = writeInquiryDto.title,
                content = writeInquiryDto.content,
                imageUrl = imageUrl,
                inquiryStatus = InquiryStatus.WAIT,
                user = user,
                createdDate = LocalDateTime.now()
            )

        commandInquiryPort.saveInquiry(inquiry)

        sendDiscordMessage(writeInquiryDto.title)

        deviceToken?.let { inquiryNotificationSendUseCase.execute(inquiry, deviceToken.deviceToken) }
    }

    private fun sendDiscordMessage(title: String) {
        val inquiryMessage = discordMessageSendPort.createInquiryMessage(title)

        discordMessageSendPort.sendDiscordMessage(inquiryMessage)
    }
}