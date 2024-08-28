package andreas311.miso.domain.inquiry.adapter.output.persistence.repository

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<InquiryEntity, Long>, InquiryRepositoryCustom {
    fun findAllByOrderByCreatedDateDesc(): List<InquiryEntity>
    fun findAllByInquiryStatusOrderByCreatedDateDesc(inquiryStatus: InquiryStatus): List<InquiryEntity>
}