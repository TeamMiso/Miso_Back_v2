package andreas311.miso.thirdparty.discord

import andreas311.miso.domain.inquiry.application.port.output.DiscordMessageSendPort
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DiscordMessageSendAdapter(
    private val okHttpClient: OkHttpClient
) : DiscordMessageSendPort {

    @Value("\${discord.webhook.url}")
    private lateinit var discordWebhookUrl: String

    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun sendDiscordMessage(message: String) {

        val requestBody = message.toRequestBody("application/json; charset=utf-8".toMediaType())

        val request = Request.Builder()
            .url(discordWebhookUrl)
            .post(requestBody)
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                log.trace("문의봇이 문의사항 요청을 성공적으로 전달했어요!")
            } else {
                log.error(response.body?.string())
                log.error("문의봇이 문의사항 요청 대신 ${response.code} 코드를 보냈어요!")
            }
        }
    }

    override fun toSingleDiscordMessage(string: String): String {
        return """
            {
                "content":"$string"
            }
        """.trimIndent()
    }

    override fun createInquiryMessage(inquiryName: String): String {
        return """
            {
                "content": "문의사항 요청이 들어왔어요!",
                "embeds": [
                    {
                        "title": "문의사항을 확인해주세요!",
                        "color": 5725911,
                        "fields": [
                            {
                                "name": "문의사항 제목",
                                "value": "$inquiryName",
                                "inline": true
                            }
                        ]
                    }
                ],
                "attachments": []
            }
        """.trimIndent()
    }
}