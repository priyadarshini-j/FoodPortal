package com.example.review2.Configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI defineOpenApi(){
        Server server= new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Food Portal");

        Info info = new Info()
                      .title("Foodie")
                      .version("0.1")
                      .description("swagger configuration");

        return new OpenAPI().info(info).servers(Arrays.asList(server));
    }

}