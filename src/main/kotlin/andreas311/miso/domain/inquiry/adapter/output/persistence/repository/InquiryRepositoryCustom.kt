package andreas311.miso.domain.inquiry.adapter.output.persistence.repository

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity

interface InquiryRepositoryCustom {
    fun filter(userEntity: UserEntity, inquiryStatus: InquiryStatus?): List<InquiryEntity>
}