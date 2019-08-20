package com.freedom.financial.network.springbootrestapi.swaggerconfig;

import static springfox.documentation.builders.PathSelectors.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freedom.financial.network.springbootrestapi.controller.Controller;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@Bean
	public Docket productApi() {
		logger.info("---------This Docket is updating the swagger documentation----------");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.freedom.financial.network.springbootrestapi"))
				.paths(regex("/springboot.*")).build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("Employee Management System")
				.contact(new Contact("Anil", "https://www.freedomfinancialnetwork.com", "anil@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}

	/**
	 * 
	 * @return
	 *//*
		 * 
		 * private ApiInfo infoDetails() { // ApiInfo(title, description, version,
		 * termsOfServiceUrl, contactName, license, // licenseUrl,vendorExtensions)
		 * logger.
		 * info("This method is used to provide extra documentation in the swagger");
		 * ApiInfo apiInfo = new ApiInfo("Spring Boot Restful API Swagger Information",
		 * "Spring Boot Restful API Swagger for Freedom Financial Network", "1.0",
		 * "Terms of service url", new Contact("Anil",
		 * "https://www.freedomfinancialnetwork.com", "anilthapa.mca@gmail.com"),
		 * "Apache License", "https://www.apache.org/license.html", null); return
		 * apiInfo; }
		 */

}
