package andreas311.miso.domain.inquiry.application.port.output

import andreas311.miso.domain.inquiry.domain.Inquiry

interface CommandInquiryPort {
    fun saveInquiry(inquiry: Inquiry): Inquiry
}