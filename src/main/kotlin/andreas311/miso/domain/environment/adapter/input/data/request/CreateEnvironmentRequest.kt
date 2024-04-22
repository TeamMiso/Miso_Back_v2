package andreas311.miso.domain.environment.adapter.input.data.request

import javax.validation.constraints.NotNull

data class CreateEnvironmentRequest(
    @field:NotNull
    val title: String,
    @field:NotNull
    val content: String
)
