package andreas311.miso.global.webhook

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebHookConfig {
    private val httpClient = OkHttpClient()

    @Bean
    fun httpClient() = httpClient
}