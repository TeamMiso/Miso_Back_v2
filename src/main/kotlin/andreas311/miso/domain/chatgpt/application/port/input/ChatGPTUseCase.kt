package andreas311.miso.domain.chatgpt.application.port.input

import andreas311.miso.domain.chatgpt.application.port.input.dto.AnswerChatDto
import andreas311.miso.domain.chatgpt.application.port.input.dto.QuestionChatDto

interface ChatGPTUseCase {
    fun execute(questionChatDto: QuestionChatDto): AnswerChatDto
}