package andreas311.miso.domain.inquiry.adapter.input.mapper

import andreas311.miso.domain.inquiry.adapter.input.data.WriteInquiryRequest
import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryDto
import org.springframework.stereotype.Component

@Component
class InquiryDataMapper {
    infix fun toDto(writeInquiryRequest: WriteInquiryRequest): WriteInquiryDto =
        WriteInquiryDto(
            title = writeInquiryRequest.title,
            content = writeInquiryRequest.content
        )
}