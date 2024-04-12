package andreas311.miso.domain.inquiry.application.port.input

import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryRespondDto

interface InquiryRespondUseCase {
    fun execute(id: Long, writeInquiryRespondDto: WriteInquiryRespondDto)
}