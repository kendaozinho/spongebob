package com.luizalabs.spongebob.swagger;

import com.luizalabs.spongebob.enumerable.Environment;
import com.luizalabs.spongebob.ApplicationUtil;
import com.luizalabs.spongebob.JwtUtil;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class SwaggerConfiguration {
    private final UUID jwtSecretKey;
    private final Environment env;
    private final ApplicationContext context;

    public SwaggerConfiguration(
            @Value("${spring.application.jwt.secret-key}") UUID jwtSecretKey,
            @Value("${spring.application.env}") Environment env,
            ApplicationContext context
    ) {
        this.jwtSecretKey = jwtSecretKey;
        this.env = env;
        this.context = context;
    }

    @Bean
    public GroupedOpenApi getGroupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch(!this.env.equals(Environment.PRODUCTION) ? "/**" : "")
                .build();
    }

    @Bean
    public OpenAPI getOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .info(
                        new Info()
                                .title("Sponge Bob API")
                                .description(
                                        "API to get Sponge Bob series info.<br/>" +
                                                (!this.env.equals(Environment.PRODUCTION) ? (JwtUtil.getEncodedJwt(this.jwtSecretKey.toString())) : "Swagger is unavailable")
                                )
                                .version(ApplicationUtil.getVersion(this.context))
                );

        if (!this.env.equals(Environment.PRODUCTION)) {
            openAPI.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                    .components(
                            new Components()
                                    .addSecuritySchemes("bearerAuth",
                                            new SecurityScheme()
                                                    .name("bearerAuth")
                                                    .type(SecurityScheme.Type.HTTP)
                                                    .scheme("bearer")
                                                    .bearerFormat("JWT")
                                    )
                    );
        }

        return openAPI;
    }
}