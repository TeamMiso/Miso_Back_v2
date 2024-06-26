package andreas311.miso.global.security.config

import andreas311.miso.global.logger.filter.LogRequestFilter
import andreas311.miso.global.security.filter.JwtExceptionFilter
import andreas311.miso.global.security.filter.JwtRequestFilter
import andreas311.miso.global.security.handler.CustomAccessDeniedHandler
import andreas311.miso.global.security.handler.CustomAuthenticationEntryPointHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtRequestFilter: JwtRequestFilter,
    private val jwtExceptionFilter: JwtExceptionFilter,
    private val logRequestFilter: LogRequestFilter
) {
    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        return http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            .antMatchers(HttpMethod.POST, "/auth").permitAll()
            .antMatchers(HttpMethod.POST, "/auth/signIn").permitAll()
            .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
            .antMatchers(HttpMethod.DELETE, "/auth").permitAll()

            .antMatchers(HttpMethod.POST, "/email").permitAll()

            .antMatchers(HttpMethod.POST, "/item").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.GET, "/item").authenticated()
            .antMatchers(HttpMethod.GET, "/item/{id}").authenticated()
            .antMatchers(HttpMethod.PATCH, "/item/{id}").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.DELETE, "/item/{id}").hasAuthority("ROLE_ADMIN")

            .antMatchers(HttpMethod.POST, "/user/give").authenticated()
            .antMatchers(HttpMethod.GET, "/user").authenticated()
            .antMatchers(HttpMethod.GET, "/user/point").authenticated()
            .antMatchers(HttpMethod.PATCH, "/user/{id}").hasAuthority("ROLE_ADMIN")

            .antMatchers(HttpMethod.POST, "/purchase/{id}").authenticated()
            .antMatchers(HttpMethod.GET, "/purchase").authenticated()

            .antMatchers(HttpMethod.POST, "/inquiry").authenticated()
            .antMatchers(HttpMethod.GET, "/inquiry").authenticated()
            .antMatchers(HttpMethod.GET, "/inquiry/filter/{state}").authenticated()
            .antMatchers(HttpMethod.GET, "/inquiry/{id}").authenticated()
            .antMatchers(HttpMethod.PATCH, "/inquiry/respond/{id}").hasAuthority("ROLE_ADMIN")

            .antMatchers(HttpMethod.POST, "/recyclables").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.POST, "/recyclables/process").authenticated()
            .antMatchers(HttpMethod.GET, "/recyclables/{type}").authenticated()
            .antMatchers(HttpMethod.GET, "/recyclables/search").authenticated()
            .antMatchers(HttpMethod.GET, "/recyclables").authenticated()
            .antMatchers(HttpMethod.PATCH, "/recyclables/{id}").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.DELETE, "/recyclables/{id}").hasAuthority("ROLE_ADMIN")

            .antMatchers(HttpMethod.POST, "/notification/save/{token}").authenticated()
            .antMatchers(HttpMethod.GET, "/notification/{id}").authenticated()

            .antMatchers(HttpMethod.GET, "/environment").authenticated()
            .antMatchers(HttpMethod.POST, "/environment").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.PATCH, "/environment/{id}").hasAuthority("ROLE_ADMIN")
            .antMatchers(HttpMethod.DELETE, "/environment/{id}").hasAuthority("ROLE_ADMIN")

            .antMatchers("/actuator/prometheus").permitAll()

            .antMatchers(HttpMethod.POST, "/chat/question").authenticated()

            .anyRequest().denyAll()
            .and()
            .exceptionHandling()
            .accessDeniedHandler(CustomAccessDeniedHandler())
            .authenticationEntryPoint(CustomAuthenticationEntryPointHandler())

            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(jwtExceptionFilter, JwtRequestFilter::class.java)
            .addFilterBefore(logRequestFilter, JwtExceptionFilter::class.java)

            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder(12)
    }
}