package andreas311.miso.domain.inquiry.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.inquiry.adapter.input.data.request.WriteInquiryRequest
import andreas311.miso.domain.inquiry.adapter.input.data.response.DetailInquiryResponse
import andreas311.miso.domain.inquiry.adapter.input.data.response.ListInquiryResponse
import andreas311.miso.domain.inquiry.adapter.input.mapper.InquiryDataMapper
import andreas311.miso.domain.inquiry.application.port.input.DetailInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.ListFilterInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.ListInquiryUseCase
import andreas311.miso.domain.inquiry.application.port.input.WriteInquiryUseCase
import andreas311.miso.domain.inquiry.domain.InquiryStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestController("/inquiry")
class InquiryAdapter(
    private val inquiryDataMapper: InquiryDataMapper,
    private val listInquiryUseCase: ListInquiryUseCase,
    private val writeInquiryUseCase: WriteInquiryUseCase,
    private val detailInquiryUseCase: DetailInquiryUseCase,
    private val listFilterInquiryUseCase: ListFilterInquiryUseCase
) {
    @PostMapping
    fun write(
        @RequestPart(value = "file") multipartFile: MultipartFile?,
        @RequestPart(value = "inquiry") @Valid writeInquiryRequest: WriteInquiryRequest
    ): ResponseEntity<Void> =
        writeInquiryUseCase.execute(inquiryDataMapper toDto writeInquiryRequest, multipartFile)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun list(): ResponseEntity<ListInquiryResponse> =
        listInquiryUseCase.execute()
            .let { inquiryDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/filter/{state}")
    fun listFiler(@PathVariable(name = "state") inquiryStatus: InquiryStatus): ResponseEntity<ListInquiryResponse> =
        listFilterInquiryUseCase.execute(inquiryStatus)
            .let { inquiryDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<DetailInquiryResponse> =
        detailInquiryUseCase.execute(id)
            .let { inquiryDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}