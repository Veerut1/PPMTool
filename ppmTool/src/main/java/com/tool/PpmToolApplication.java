package com.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@EnableJpaAuditing
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Explore PPMTOOL API",
				description="API Definitions of the PPMTOOL Microservice",
				version="1.0.1"
		))

public class PpmToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpmToolApplication.class, args);
	}
	
	
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) { 
		  return applicationBuilder.sources(PpmToolApplication.class); }
	 
}
