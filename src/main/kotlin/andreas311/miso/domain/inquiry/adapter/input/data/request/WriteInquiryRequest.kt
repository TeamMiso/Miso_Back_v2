package andreas311.miso.domain.inquiry.adapter.input.data.request

import javax.validation.constraints.NotNull

data class WriteInquiryRequest(
    @field:NotNull
    val title: String,
    @field:NotNull
    val content: String
)
