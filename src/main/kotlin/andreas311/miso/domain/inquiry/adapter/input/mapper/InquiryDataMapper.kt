package andreas311.miso.domain.inquiry.adapter.input.mapper

import andreas311.miso.domain.inquiry.adapter.input.data.request.WriteInquiryRequest
import andreas311.miso.domain.inquiry.adapter.input.data.response.DetailInquiryResponse
import andreas311.miso.domain.inquiry.adapter.input.data.response.InquiryResponse
import andreas311.miso.domain.inquiry.adapter.input.data.response.ListInquiryResponse
import andreas311.miso.domain.inquiry.application.port.input.dto.DetailInquiryDto
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

    fun toResponse(detailInquiryDto: DetailInquiryDto): DetailInquiryResponse =
        DetailInquiryResponse(
            id = detailInquiryDto.id,
            inquiryDate = detailInquiryDto.inquiryDate,
            title = detailInquiryDto.title,
            content = detailInquiryDto.content,
            imageUrl = detailInquiryDto.imageUrl,
            inquiryStatus = detailInquiryDto.inquiryStatus
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