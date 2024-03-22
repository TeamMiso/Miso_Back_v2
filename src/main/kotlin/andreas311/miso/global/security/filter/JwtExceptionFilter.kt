package andreas311.miso.global.security.filter

import andreas311.miso.global.error.ErrorCode
import andreas311.miso.global.error.response.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtExceptionFilter : OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(this.javaClass.simpleName)

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure { exception ->
            val errorCode = when (exception) {
                is ExpiredJwtException -> ErrorCode.TOKEN_IS_EXPIRED
                is JwtException, is IllegalArgumentException -> ErrorCode.TOKEN_NOT_VALID
                else -> ErrorCode.UNKNOWN_ERROR
            }

            setErrorResponse(errorCode, response)
                .also {
                    val debugMessage = when (exception) {
                        is ExpiredJwtException -> "ExpiredJwtException"
                        is JwtException -> "JwtException"
                        is IllegalArgumentException -> "IllegalArgumentException"
                        else -> "Exception"
                    }
                    log.debug("================= [ ExceptionHandlerFilter ] 에서 $debugMessage 발생 ===================")
                    if (exception is IllegalArgumentException) {
                        exception.printStackTrace()
                    }
                }
        }
    }

    private fun setErrorResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"
        val errorResponse = ErrorResponse(errorCode.status, errorCode.message)
        val errorResponseToJson = ObjectMapper().writeValueAsString(errorResponse)
        response.writer.write(errorResponseToJson)
    }
}
