package andreas311.miso.domain.chatgpt.adapter.input.mapper

import andreas311.miso.domain.chatgpt.adapter.input.data.request.QuestionChatRequest
import andreas311.miso.domain.chatgpt.adapter.input.data.response.AnswerChatResponse
import andreas311.miso.domain.chatgpt.application.port.input.dto.AnswerChatDto
import andreas311.miso.domain.chatgpt.application.port.input.dto.QuestionChatDto
import org.springframework.stereotype.Component

@Component
class ChatGPTDataMapper {
    infix fun toDto(questionChatRequest: QuestionChatRequest): QuestionChatDto =
        QuestionChatDto(
            question = questionChatRequest.question
        )

    fun toResponse(answerChatDto: AnswerChatDto): AnswerChatResponse =
        AnswerChatResponse(
            answer = answerChatDto.answer
        )
}