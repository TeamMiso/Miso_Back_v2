package andreas311.miso.thirdparty.email

import andreas311.miso.domain.email.application.exception.EmailSendFailedException
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.application.port.output.EmailSendPort
import andreas311.miso.domain.email.domain.Email
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring5.SpringTemplateEngine
import java.util.*
import javax.mail.MessagingException

@Component
class EmailSendAdapter(
    private val javaMailSender: JavaMailSender,
    private val commandEmailPort: CommandEmailPort,
    private val springTemplateEngine: SpringTemplateEngine
) : EmailSendPort {
    override fun sendEmailAuthKey(email: String) {
        val randomKey = createRandomKey()
        sendAuthEmail(email, randomKey)
    }

    private fun sendAuthEmail(email: String, randomKey: String) {
        try {
            sendEmail(email, randomKey)
        } catch (e: MessagingException) {
            throw EmailSendFailedException()
        }
        saveEmailToRepository(email, randomKey)
    }

    private fun saveEmailToRepository(email: String, randomKey: String) {
        commandEmailPort.saveEmail(
            Email(
                id = 0L,
                email = email,
                randomKey = randomKey,
                authentication = false
            )
        )
    }

    private fun sendEmail(email: String, randomKey: String) {
        val mimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(mimeMessage, true, "utf-8")
        val mailTemplate = createMailTemplate(randomKey)
        helper.setTo(email)
        helper.setSubject("MISO 인증번호가 도착했습니다!")
        helper.setText(mailTemplate, true)
        javaMailSender.send(mimeMessage)
    }

    private fun createRandomKey(): String {
        val random = Random()

        val randomKey = random.nextInt(8888) + 1111

        return randomKey.toString()
    }

    private fun createMailTemplate(randomKey: String): String {
        val content = Context()
        val randomKey = randomKey
        content.setVariables(
            mapOf(
                "randomKey" to randomKey
            )
        )
        return springTemplateEngine.process("mailTemplate", content)
    }
}