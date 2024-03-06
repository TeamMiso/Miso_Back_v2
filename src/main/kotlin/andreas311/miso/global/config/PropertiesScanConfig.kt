package andreas311.miso.global.config

import andreas311.miso.global.redis.properties.RedisProperties
import andreas311.miso.global.security.jwt.common.properties.JwtProperties
import andreas311.miso.global.security.jwt.common.properties.JwtTimeProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        RedisProperties::class,
        JwtProperties::class,
        JwtTimeProperties::class
    ]
)
class PropertiesScanConfig