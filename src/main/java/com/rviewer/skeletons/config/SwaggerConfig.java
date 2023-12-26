package com.rviewer.skeletons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.util.Collections;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(false)
                .forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "E-wok API",
                "E-wok API is a REST API responsible for managing the E-wok online home delivery service orders.",
                "1.0.0",
                "Terms of service",
                new Contact("Your Name", "Your website", "your.email@example.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
