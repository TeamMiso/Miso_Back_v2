package andreas311.miso.global.config

import andreas311.miso.global.redis.properties.RedisProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        RedisProperties::class
    ]
)
class PropertiesScanConfig