package andreas311.miso.global.security.jwt.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt.time")
class JwtTimeProperties(
    val accessTime: Long,
    val refreshTime: Long
)