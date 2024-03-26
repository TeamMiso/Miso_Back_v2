package andreas311.miso.domain.inquiry.adapter.output.persistence

import andreas311.miso.domain.inquiry.adapter.output.persistence.mapper.InquiryMapper
import andreas311.miso.domain.inquiry.adapter.output.persistence.repository.InquiryRepository
import andreas311.miso.domain.inquiry.application.port.output.QueryInquiryPort
import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import andreas311.miso.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class QueryInquiryPersistenceAdapter(
    private val userMapper: UserMapper,
    private val inquiryMapper: InquiryMapper,
    private val inquiryRepository: InquiryRepository
) : QueryInquiryPort {
    override fun findAll(): List<Inquiry> {
        val inquiryList = inquiryRepository.findAllByOrderByCreatedDateDesc()
        return inquiryList.map { inquiryMapper.toDomain(it) }
    }

    override fun findAllByUser(user: User): List<Inquiry> {
        val inquiryList = inquiryRepository.findByUserOrderByCreatedDateDesc(userMapper.toEntity(user))
        return inquiryList.map { inquiryMapper.toDomain(it) }
    }
}