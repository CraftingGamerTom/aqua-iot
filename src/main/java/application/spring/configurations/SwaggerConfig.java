/**
 * Copyright (c) 2018 Thomas Rokicki
 */

package application.spring.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.spring.settings.AppConfig;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	AppConfig appConfig;

	/**
	 * https://github.com/springfox/springfox/issues/1615
	 * 
	 * @return
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("application.controllers.rest")).paths(PathSelectors.any())
				.build().pathMapping("/").apiInfo(metaData());

	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Site for Aquarium IoT")
				.description("For Aquarium Things")
				.version(appConfig.getApiConfig().getVersion()).license("Copyright Thomas Rokicki 2018")
				.licenseUrl("NO LICENSE")
				.contact(new Contact("Thomas Rokicki", "https://thomasrokicki.com", "tomwrhs@gmail.com")).build();
	}
}
