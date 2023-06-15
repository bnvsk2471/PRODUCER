package com.Student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class StudentSwaggerConfig {
	
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)//UI screen type
				.select() // To specify RestControllers
				.apis(RequestHandlerSelectors.basePackage("com.Student.Controller"))// base package for rest controllers
				.paths(PathSelectors.regex("/student"))  // Here any indicates all endpoints are accessed to swagger
				.build();
	}

}
