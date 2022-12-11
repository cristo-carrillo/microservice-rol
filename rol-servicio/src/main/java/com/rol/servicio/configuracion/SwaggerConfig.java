package com.rol.servicio.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rol.servicio.controlador"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot Rol API REST",
                "rol Api rest docs",
                "1.0",
                "http://www.google.com",
                new Contact("Email", "http://www.google.com", "cjcarrillos@ufpso.edu.co ; ypradol@ufpso.edu.co; jjbarbosal@ufpso.edu.co"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }
}

