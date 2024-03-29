package andreas311.miso.domain.user.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.user.adapter.input.data.response.PointResponse
import andreas311.miso.domain.user.adapter.input.data.response.UserInfoResponse
import andreas311.miso.domain.user.adapter.input.mapper.UserDataMapper
import andreas311.miso.domain.user.application.port.input.GetPointUseCase
import andreas311.miso.domain.user.application.port.input.GivePointUseCase
import andreas311.miso.domain.user.application.port.input.UserInfoUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@RequestController("/user")
class UserAdapter(
    private val userDataMapper: UserDataMapper,
    private val userInfoUseCase: UserInfoUseCase,
    private val getPointUseCase: GetPointUseCase,
    private val givePointUseCase: GivePointUseCase
) {
    @PostMapping("/give")
    fun givePoint(): ResponseEntity<Void> =
        givePointUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @GetMapping
    fun userInfo(): ResponseEntity<UserInfoResponse> =
        userInfoUseCase.execute()
            .let { userDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/point")
    fun getPoint(): ResponseEntity<PointResponse> =
        getPointUseCase.execute()
            .let { userDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}