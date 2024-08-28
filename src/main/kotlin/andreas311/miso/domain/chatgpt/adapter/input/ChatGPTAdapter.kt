package andreas311.miso.domain.chatgpt.adapter.input

import andreas311.miso.common.annotation.RequestController
import andreas311.miso.domain.chatgpt.adapter.input.data.request.QuestionChatRequest
import andreas311.miso.domain.chatgpt.adapter.input.data.response.AnswerChatResponse
import andreas311.miso.domain.chatgpt.adapter.input.mapper.ChatGPTDataMapper
import andreas311.miso.domain.chatgpt.application.port.input.ChatGPTUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RequestController("/chat")
class ChatGPTAdapter(
    private val chatGPTDataMapper: ChatGPTDataMapper,
    private val chatGPTUseCase: ChatGPTUseCase
) {
    @PostMapping("/question")
    fun question(@RequestBody questionChatRequest: QuestionChatRequest): ResponseEntity<AnswerChatResponse> =
        chatGPTUseCase.execute(chatGPTDataMapper toDto questionChatRequest)
            .let { chatGPTDataMapper.toResponse(it) }
            .let { ResponseEntity.status(HttpStatus.OK).body(it) }
}