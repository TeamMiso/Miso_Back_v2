package andreas311.miso.domain.inquiry.adapter.output.persistence.repository.impl

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.QInquiryEntity.inquiryEntity
import andreas311.miso.domain.inquiry.adapter.output.persistence.repository.InquiryRepositoryCustom
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class InquiryRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : InquiryRepositoryCustom {
    override fun filter(userEntity: UserEntity, inquiryStatus: InquiryStatus?): List<InquiryEntity> {
        return jpaQueryFactory
            .selectFrom(inquiryEntity)
            .where(
                inquiryEntity.user.eq(userEntity),
                inquiryStatusEq(inquiryStatus)
            )
            .fetch()
    }

    private fun inquiryStatusEq(inquiryStatus: InquiryStatus?): BooleanExpression? =
        if(inquiryStatus != null) inquiryEntity.inquiryStatus.eq(inquiryStatus) else null
}