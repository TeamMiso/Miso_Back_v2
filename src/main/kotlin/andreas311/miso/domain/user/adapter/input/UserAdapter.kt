package andreas311.miso.domain.user.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.user.adapter.input.data.request.EditUserInfoRequest
import andreas311.miso.domain.user.adapter.input.data.response.PointResponse
import andreas311.miso.domain.user.adapter.input.data.response.UserInfoResponse
import andreas311.miso.domain.user.adapter.input.mapper.UserDataMapper
import andreas311.miso.domain.user.application.port.input.EditUserInfoUseCase
import andreas311.miso.domain.user.application.port.input.GetPointUseCase
import andreas311.miso.domain.user.application.port.input.GivePointUseCase
import andreas311.miso.domain.user.application.port.input.GetUserInfoUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

@RequestController("/user")
class UserAdapter(
    private val userDataMapper: UserDataMapper,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getPointUseCase: GetPointUseCase,
    private val givePointUseCase: GivePointUseCase,
    private val editUserInfoUseCase: EditUserInfoUseCase
) {
    @PostMapping("/give")
    fun givePoint(): ResponseEntity<Void> =
        givePointUseCase.execute()
            .let { ResponseEntity.status(HttpStatus.OK).build() }

    @GetMapping
    fun getUserInfo(): ResponseEntity<UserInfoResponse> =
        getUserInfoUseCase.execute()
            .let { userDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/point")
    fun getPoint(): ResponseEntity<PointResponse> =
        getPointUseCase.execute()
            .let { userDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @PatchMapping("/{id}")
    fun editUserInfo(@PathVariable id: UUID, @RequestBody editUserInfoRequest: EditUserInfoRequest): ResponseEntity<Void> =
        editUserInfoUseCase.execute(id, userDataMapper toDto editUserInfoRequest)
            .let { ResponseEntity.status(HttpStatus.OK).build() }
}