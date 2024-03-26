package andreas311.miso.domain.inquiry.adapter.output.persistence.mapper

import andreas311.miso.domain.inquiry.adapter.output.persistence.entity.InquiryEntity
import andreas311.miso.domain.inquiry.domain.Inquiry
import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class InquiryMapper(
    private val userMapper: UserMapper
) {
    infix fun toEntity(domain: Inquiry): InquiryEntity =
        InquiryEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            imageUrl = domain.imageUrl,
            inquiryStatus = domain.inquiryStatus,
            user = userMapper.toEntity(domain.user),
            createdDate = domain.createdDate
        )

    infix fun toDomain(entity: InquiryEntity?): Inquiry? =
        entity?.let {
            Inquiry(
                id = entity.id,
                title = entity.title,
                content = entity.content,
                imageUrl = entity.imageUrl,
                inquiryStatus = entity.inquiryStatus,
                user = userMapper.toDomain(entity.user)!!,
                createdDate = entity.createdDate
            )
        }
}