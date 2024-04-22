package andreas311.miso.domain.inquiry.application.port.output

import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.domain.User

interface QueryInquiryPort {
    fun findByIdOrNull(id: Long): Inquiry?
    fun findAll(): List<Inquiry>
    fun findAllByUser(user: User): List<Inquiry>
    fun findAllByInquiryStatus(inquiryStatus: InquiryStatus): List<Inquiry>
    fun findAllByUserAndInquiryStatus(user: User, inquiryStatus: InquiryStatus): List<Inquiry>
}