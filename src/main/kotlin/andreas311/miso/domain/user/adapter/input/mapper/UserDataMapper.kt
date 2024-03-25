package andreas311.miso.domain.user.adapter.input.mapper

import andreas311.miso.domain.user.adapter.input.data.response.UserInfoResponse
import andreas311.miso.domain.user.application.port.input.dto.UserInfoDto
import org.springframework.stereotype.Component

@Component
class UserDataMapper {
    fun toResponse(userInfoDto: UserInfoDto): UserInfoResponse =
        UserInfoResponse(
            id = userInfoDto.id,
            email = userInfoDto.email,
            role = userInfoDto.role
        )
}