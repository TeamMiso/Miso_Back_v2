package andreas311.miso.domain.inquiry.application.port.input

import andreas311.miso.domain.inquiry.application.port.input.dto.WriteInquiryDto
import org.springframework.web.multipart.MultipartFile

interface WriteInquiryUseCase {
    fun execute(writeInquiryDto: WriteInquiryDto, multipartFile: MultipartFile?)
}