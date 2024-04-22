package andreas311.miso.global.webclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ClientHttpConnector
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration

@Configuration
class WebClientConfig {
    @Bean
    fun webClient(): WebClient {
        val httpClient = HttpClient.create().responseTimeout(Duration.ofMinutes(1))
        val connector: ClientHttpConnector = ReactorClientHttpConnector(httpClient)

        return WebClient.builder()
            .clientConnector(connector)
            .exchangeStrategies(ExchangeStrategies.builder()
                .codecs { configurer ->
                    configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)
                }
                .build())
            .build()
    }
}