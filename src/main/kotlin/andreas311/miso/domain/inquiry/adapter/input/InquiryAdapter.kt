package andreas311.miso.domain.inquiry.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.inquiry.adapter.input.data.WriteInquiryRequest
import andreas311.miso.domain.inquiry.adapter.input.mapper.InquiryDataMapper
import andreas311.miso.domain.inquiry.application.port.input.WriteInquiryUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/inquiry")
class InquiryAdapter(
    private val inquiryDataMapper: InquiryDataMapper,
    private val writeInquiryUseCase: WriteInquiryUseCase
) {
    @PostMapping
    fun write(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "inquiry") @Valid writeInquiryRequest: WriteInquiryRequest
    ): ResponseEntity<Void> =
        writeInquiryUseCase.execute(inquiryDataMapper toDto writeInquiryRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}