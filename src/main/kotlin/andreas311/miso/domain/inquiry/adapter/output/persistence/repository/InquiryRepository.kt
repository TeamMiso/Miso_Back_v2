package andreas311.miso.domain.inquiry.adapter.output.persistence.repository

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<InquiryEntity, Long> {
    fun findAllByOrderByCreatedDateDesc(): List<InquiryEntity>
    fun findByUserOrderByCreatedDateDesc(userEntity: UserEntity): List<InquiryEntity>
    fun findAllByInquiryStatusOrderByCreatedDateDesc(inquiryStatus: InquiryStatus): List<InquiryEntity>
    fun findByUserAndInquiryStatusOrderByCreatedDateDesc(userEntity: UserEntity, inquiryStatus: InquiryStatus): List<InquiryEntity>
}