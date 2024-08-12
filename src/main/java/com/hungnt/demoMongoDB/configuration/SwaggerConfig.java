package com.hungnt.demoMongoDB.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Document")
                        .version("v1")
                        .description("API Service - MongoDB")
                ).servers(
                        List.of(
                                new Server().url("http://localhost:8879").description("LocalServer")
                        )
                );
    }

    @Bean
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group("API CRUD USER")
                .packagesToScan("com.hungnt.demoMongoDB.controller")
                .build();
    }
}

//http://localhost:8879/swagger-ui/index.html