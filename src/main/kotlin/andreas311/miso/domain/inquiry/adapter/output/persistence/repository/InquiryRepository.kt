package andreas311.miso.domain.inquiry.adapter.output.persistence.repository

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import org.springframework.data.repository.CrudRepository

interface InquiryRepository : CrudRepository<InquiryEntity, Long> {
}