package andreas311.miso.domain.inquiry.adapter.input.data.request

import javax.validation.constraints.NotNull

data class WriteInquiryRespondRequest(
    @field:NotNull
    val answer: String
)
