package com.walker.learningspringsecurity.configuration;

import com.walker.learningspringsecurity.security.CustomBasicAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity //Ao adicionar a anotação @EnableWebSecurity a uma classe de configuração, você está indicando ao Spring que a aplicação deve ser configurada para suportar segurança web e que você deseja personalizar essa configuração.
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {
    private final CustomBasicAuthenticationFilter customBasicAuthenticationFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(antMatcher(HttpMethod.POST, "/users/**")).permitAll()
                        .anyRequest().authenticated()
                ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(
                        customBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }
}
