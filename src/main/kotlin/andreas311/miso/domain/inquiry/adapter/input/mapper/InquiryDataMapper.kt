package andreas311.miso.domain.inquiry.adapter.input.mapper

import andreas311.miso.domain.inquiry.adapter.input.data.request.WriteInquiryRequest
import andreas311.miso.domain.inquiry.adapter.input.data.response.InquiryResponse
import andreas311.miso.domain.inquiry.adapter.input.data.response.ListInquiryResponse
import andreas311.miso.domain.inquiry.application.port.input.dto.ListInquiryDto
import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryDto
import org.springframework.stereotype.Component

@Component
class InquiryDataMapper {
    infix fun toDto(writeInquiryRequest: WriteInquiryRequest): WriteInquiryDto =
        WriteInquiryDto(
            title = writeInquiryRequest.title,
            content = writeInquiryRequest.content
        )

    fun toResponse(listInquiryDto: ListInquiryDto): ListInquiryResponse =
        ListInquiryResponse(
            listInquiryDto.inquiryList
                .map {
                    InquiryResponse(
                        id = it.id,
                        inquiryDate = it.inquiryDate,
                        title = it.title,
                        imageUrl = it.imageUrl,
                        inquiryStatus = it.inquiryStatus
                    )
                }
        )
}