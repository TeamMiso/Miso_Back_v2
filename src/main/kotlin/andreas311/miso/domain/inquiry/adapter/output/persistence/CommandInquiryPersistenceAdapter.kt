package andreas311.miso.domain.inquiry.adapter.output.persistence

import andreas311.miso.domain.inquiry.adapter.output.persistence.mapper.InquiryMapper
import andreas311.miso.domain.inquiry.adapter.output.persistence.repository.InquiryRepository
import andreas311.miso.domain.inquiry.application.port.output.CommandInquiryPort
import andreas311.miso.domain.inquiry.domain.Inquiry
import org.springframework.stereotype.Component

@Component
class CommandInquiryPersistenceAdapter(
    private val inquiryMapper: InquiryMapper,
    private val inquiryRepository: InquiryRepository
) : CommandInquiryPort {
    override fun saveInquiry(inquiry: Inquiry): Inquiry {
        val inquiryEntity = inquiryRepository.save(inquiryMapper toEntity inquiry)
        return inquiryMapper.toDomain(inquiryEntity)
    }
}