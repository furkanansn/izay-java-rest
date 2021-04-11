package ariservice.izay.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import ariservice.izay.blog.entity.Blog;
import ariservice.izay.category.entity.Category;
import ariservice.izay.documents.entity.Document;
import ariservice.izay.home.entity.Home;
import ariservice.izay.meetUs.entity.MeetUs;
import ariservice.izay.product.entity.Product;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket apiDocket() {
		
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Izay Rest Api")
				.description("From Bee Creative")
				.build();
		
        return new Docket(DocumentationType.OAS_30)
        		.apiInfo(apiInfo)
                .select()                
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}