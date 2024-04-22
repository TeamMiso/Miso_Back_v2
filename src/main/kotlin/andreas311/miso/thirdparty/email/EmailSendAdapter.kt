package andreas311.miso.thirdparty.email

import andreas311.miso.domain.email.application.exception.EmailSendFailedException
import andreas311.miso.domain.email.application.port.output.CommandEmailPort
import andreas311.miso.domain.email.application.port.output.EmailSendPort
import andreas311.miso.domain.email.domain.Email
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import java.util.*
import javax.mail.MessagingException

@Component
class EmailSendAdapter(
    private val javaMailSender: JavaMailSender,
    private val commandEmailPort: CommandEmailPort
) : EmailSendPort {
    override fun sendEmailAuthKey(email: String) {
        val randomKey = createRandomKey()
        sendAuthEmail(email, randomKey)
    }

    private fun sendAuthEmail(email: String, randomKey: String) {
        val subject = "MISO 인증번호가 도착했습니다!"
        val content = buildEmailContent(randomKey)

        try {
            sendEmail(email, subject, content)
        } catch (e: MessagingException) {
            throw EmailSendFailedException()
        }
        saveEmailToRepository(email, randomKey)
    }

    private fun buildEmailContent(randomKey: String): String {
        return """
            <div style='margin:100px;'>
            <h1> 안녕하세요 MISO 입니다! </h1>
            <br>
            <h2><p>아래 인증번호를 인증 페이지로 돌아가 입력해 주세요. 이용해 주셔서 감사합니다!<p></h2>
            <br>
            <div align='center' style='border:1px solid black; font-family:verdana';>
            <h3 style='color:blue;'>인증번호는 다음과 같습니다!</h3>
            <div style='font-size:130%'>
            인증번호 : <strong>$randomKey</strong><div><br/> 
            </div>
        """.trimIndent()
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

    private fun sendEmail(email: String, subject: String, content: String) {
        val mimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(mimeMessage, true, "utf-8")
        helper.setTo(email)
        helper.setSubject(subject)
        helper.setText(content, true)
        javaMailSender.send(mimeMessage)
    }

    private fun createRandomKey(): String {
        val random = Random()

        val randomKey = random.nextInt(8888) + 1111

        return randomKey.toString()
    }
}