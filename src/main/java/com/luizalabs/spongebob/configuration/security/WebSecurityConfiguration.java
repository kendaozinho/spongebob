package com.luizalabs.spongebob.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizalabs.spongebob.domain.exception.dto.BaseResponseError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  private final UUID jwtSecretKey;
  private final ObjectMapper mapper;

  public WebSecurityConfiguration(
      @Value("${spring.application.jwt.secret-key}") UUID jwtSecretKey,
      ObjectMapper mapper
  ) {
    this.jwtSecretKey = jwtSecretKey;
    this.mapper = mapper;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(
            new JwtInterceptorConfiguration(this.jwtSecretKey.toString()),
            UsernamePasswordAuthenticationFilter.class
        )
        .exceptionHandling()
        .authenticationEntryPoint((request, response, e) -> {
          response.setStatus(HttpStatus.UNAUTHORIZED.value());
          response.setContentType("application/json");
          response.getWriter().write(
              this.mapper.writeValueAsString(
                  new BaseResponseError(
                      HttpStatus.UNAUTHORIZED.value(),
                      HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                      "Authorization is empty or invalid"
                  )
              )
          );
        })
        .and()
        .cors();
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(
        "/",
        "/docs",
        "/docs/",
        "/swagger",
        "/swagger/",
        "/swagger-ui",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/swagger-resources/**",
        "/v2/api-docs",
        "/v3/api-docs/**",
        "/actuator/**"
    );
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    // Remove UserDetailsServiceAutoConfiguration output log
  }
}
