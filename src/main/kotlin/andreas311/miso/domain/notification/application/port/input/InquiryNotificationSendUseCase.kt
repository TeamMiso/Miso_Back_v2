package andreas311.miso.domain.notification.application.port.input

import andreas311.miso.domain.inquiry.domain.Inquiry

interface InquiryNotificationSendUseCase {
    fun execute(inquiry: Inquiry, token: String)
}