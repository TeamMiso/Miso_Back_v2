package andreas311.miso.domain.user.adapter.input.mapper

import andreas311.miso.domain.user.adapter.input.data.request.EditUserInfoRequest
import andreas311.miso.domain.user.adapter.input.data.response.PointResponse
import andreas311.miso.domain.user.adapter.input.data.response.UserInfoResponse
import andreas311.miso.domain.user.application.port.input.dto.EditUserInfoDto
import andreas311.miso.domain.user.application.port.input.dto.PointDto
import andreas311.miso.domain.user.application.port.input.dto.UserInfoDto
import org.springframework.stereotype.Component

@Component
class UserDataMapper {
    infix fun toDto(editUserInfoRequest: EditUserInfoRequest): EditUserInfoDto =
        EditUserInfoDto(
            email = editUserInfoRequest.email,
            point = editUserInfoRequest.point,
            role = editUserInfoRequest.role
        )

    fun toResponse(userInfoDto: UserInfoDto): UserInfoResponse =
        UserInfoResponse(
            id = userInfoDto.id,
            email = userInfoDto.email,
            role = userInfoDto.role
        )

    fun toResponse(pointDto: PointDto): PointResponse =
        PointResponse(
            point = pointDto.point
        )
}