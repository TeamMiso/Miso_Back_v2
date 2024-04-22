package andreas311.miso.domain.inquiry.application.port.output

interface DiscordMessageSendPort {
    fun sendDiscordMessage(message: String)
    fun toSingleDiscordMessage(string: String): String
    fun createInquiryMessage(inquiryName: String): String
}