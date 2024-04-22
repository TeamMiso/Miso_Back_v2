package andreas311.miso.domain.notification.adapter.output.persistence.mapper

import andreas311.miso.domain.inquiry.adapter.output.persistence.mapper.InquiryMapper
import andreas311.miso.domain.notification.adapter.output.persistence.entity.NotificationEntity
import andreas311.miso.domain.notification.domain.Notification
import andreas311.miso.domain.user.adapter.output.persistence.mapper.UserMapper
import org.springframework.stereotype.Component

@Component
class NotificationMapper(
    private val userMapper: UserMapper,
    private val inquiryMapper: InquiryMapper
) {
    infix fun toEntity(domain: Notification): NotificationEntity =
        NotificationEntity(
            id = domain.id,
            answer = domain.answer,
            user = userMapper toEntity domain.user,
            inquiry = inquiryMapper toEntity domain.inquiry
        )

    infix fun toDomain(entity: NotificationEntity?): Notification? =
        entity?.let {
            Notification(
                id = entity.id,
                answer = entity.answer,
                user = userMapper.toDomain(entity.user)!!,
                inquiry = inquiryMapper.toDomain(entity.inquiry)!!
            )
        }
}