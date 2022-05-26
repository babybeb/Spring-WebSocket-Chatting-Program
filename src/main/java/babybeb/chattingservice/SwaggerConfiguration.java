package babybeb.chattingservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {
    
    private final String version = "v0";
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("chatting-service API")
            .description("Swagger for chatting-service")
            .build();
    }
    
    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName(version)
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
    }
}