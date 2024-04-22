package andreas311.miso.domain.email.adapter.input.data.request

import javax.validation.constraints.NotNull

data class RandomKeyRequest(
    @field:NotNull
    val randomKey: String
)
