package com.ecommerce.microcommerce.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.ecommerce.microcommerce"))
                .paths((Predicate<String>) PathSelectors.any())
                .build()
                .apiInfo(apiInfo().build());
    }

    private ApiInfoBuilder apiInfo() {
        return new ApiInfoBuilder()
                .title("API Documentation")
                .description("API documentation")
                .version("1.0.0");
    }
}
