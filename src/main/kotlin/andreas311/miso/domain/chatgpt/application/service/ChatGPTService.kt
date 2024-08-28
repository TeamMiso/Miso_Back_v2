package andreas311.miso.domain.chatgpt.application.service

import andreas311.miso.common.annotation.ReadOnlyRollbackService
import andreas311.miso.domain.chatgpt.application.port.input.ChatGPTUseCase
import andreas311.miso.domain.chatgpt.application.port.input.dto.AnswerChatDto
import andreas311.miso.domain.chatgpt.application.port.input.dto.QuestionChatDto
import io.github.flashvayne.chatgpt.service.ChatgptService

@ReadOnlyRollbackService
class ChatGPTService(
    private val chatgptService: ChatgptService
) : ChatGPTUseCase {
    override fun execute(questionChatDto: QuestionChatDto): AnswerChatDto {
        return AnswerChatDto(chatgptService.sendMessage(questionChatDto.question))
    }
}