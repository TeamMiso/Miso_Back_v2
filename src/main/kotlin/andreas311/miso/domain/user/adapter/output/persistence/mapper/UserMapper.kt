package andreas311.miso.domain.user.adapter.output.persistence.mapper

import andreas311.miso.domain.user.adapter.output.persistence.entity.UserEntity
import andreas311.miso.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toDomain(entity: UserEntity?): User? =
        entity?.let {
            User(
                id = entity.id,
                email = entity.email,
                password = entity.password,
                point = entity.point,
                role = entity.role
            )
        }
}