package ru.itmo.usermanagementservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import ru.itmo.usermanagementservice.security.JwtAuthorizationFilter
import ru.itmo.usermanagementservice.security.JwtTokenProvider
import ru.itmo.usermanagementservice.security.UserDetailsServiceImpl

@Configuration
class SecurityConfig(
    private val userDetailsService: UserDetailsServiceImpl,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun securityFilterChain(
        http: HttpSecurity,
        authManager: AuthenticationManager,
    ): SecurityFilterChain {
        val jwtAuthorizationFilter = JwtAuthorizationFilter(jwtTokenProvider, userDetailsService)

        http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth
                    // Permit all POST requests to /api/auth/register and /api/auth/login
                    .requestMatchers(HttpMethod.POST, "/api/auth/register", "/api/auth/login", "/api/auth/verify").permitAll()
                    // Permit all GET requests to Actuator endpoints
                    .requestMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                    // Any other request must be authenticated
                    .anyRequest().authenticated()
            }
            .userDetailsService(userDetailsService)
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}
